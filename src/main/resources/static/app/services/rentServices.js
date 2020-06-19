angular.module('app')
    .constant('RENT_ENDPOINT', '/api/rents/:id')
    .constant('RENT_ASSIGMENTS_ENDPOINT', '/api/rents/:id/assignments')
    .factory('Rent', function ($resource, RENT_ENDPOINT, RENT_ASSIGMENTS_ENDPOINT) {
        return $resource(RENT_ENDPOINT, {id: '@_id'}, {
            update: {
                method: 'PUT'
            },
            getAssignments: {
                method: 'GET',
                url: RENT_ASSIGMENTS_ENDPOINT,
                params: {id: '@id'},
                isArray: true
            }
        });
    })
    .service('RentService', function (Rent) {
        this.getAll = params => Rent.query(params);
        this.get = index => Rent.get({id: index});
        this.getAssignments = index => Rent.getAssignments({id: index});
        this.save = rent => rent.$save();
        this.update = rent => rent.$update({id: rent.id});
    });
