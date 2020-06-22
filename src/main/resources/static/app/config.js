angular.module('app')
.config(function ($routeProvider) {
    $routeProvider
        .when('/users', {
            templateUrl: 'app/components/users/list/userList.html',
            controller: 'UserListController',
            controllerAs: 'ctrl'
        })
        .when('/user-edit/:userId', {
            templateUrl: 'app/components/users/edit/userEdit.html',
            controller: 'UserEditController',
            controllerAs: 'ctrl'
        })
        .when('/user-add', {
            templateUrl: 'app/components/users/edit/userEdit.html',
            controller: 'UserEditController',
            controllerAs: 'ctrl'
        })
        .when('/user-rents/:userId', {
            templateUrl: 'app/components/users/rents/userRents.html',
            controller: 'UserRentsController',
            controllerAs: 'ctrl'
        })
        .when('/rents', {
            templateUrl: 'app/components/rents/list/rentList.html',
            controller: 'RentListController',
            controllerAs: 'ctrl'
        })
        .when('/rent-edit/:rentId', {
            templateUrl: 'app/components/rents/edit/rentEdit.html',
            controller: 'RentEditController',
            controllerAs: 'ctrl'
        })
        .when('/rent-add', {
            templateUrl: 'app/components/rents/edit/rentEdit.html',
            controller: 'RentEditController',
            controllerAs: 'ctrl'
        })
        .when('/rent-history/:rentId', {
            templateUrl: 'app/components/rents/history/rentHistory.html',
            controller: 'RentHistoryController',
            controllerAs: 'ctrl'
        })
        .otherwise({
            redirectTo: '/users'
        })
});