angular.module('app')
.controller('RentHistoryController', function ($routeParams,
                                               RentService,
                                               Assignment, AssignmentService, AssignmentEndService,
                                               UserService) {

    const vm = this;
    const vn = this;
    const rentId = $routeParams.rentId;
    vm.rent = RentService.get(rentId);

    vn.users = UserService.getAll();

    vn.search = lastName => {
        vn.users = UserService.getAll({lastName});
    };

    const refreshData = () => {
        vm.assigned = false;
        vm.assignments = RentService.getAssignments(rentId);
        vm.assignments.$promise.then(assignments => {
            const activeAssignment = vm.assignments.filter(a => a.end == null);
            if(activeAssignment.length) {
                vm.assigned = true;
            }
        });
    };

    const errerCallBack = err => {
        vm.msg = `Błąd zapisu: ${err.data.message}`;
    };
    vm.finishAssignment = assignment => {
        AssignmentEndService.save(assignment.id)
            .then(response => {
                assignment.end = response.data;
                vm.assigned = false;
            })
            .catch(errerCallBack);
    };
    vm.search = lastName => {
        vm.users = UserService.getAll({lastName});
    };

    vm.rentToUser = user => {
        const assignment = new Assignment();
        assignment.userId = user.id;
        assignment.rentId = vm.rent.id;
        AssignmentService.save(assignment)
            .then(refreshData())
            .catch(errerCallBack);
    };
    refreshData();
});
