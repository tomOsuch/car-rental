angular.module('app')
.controller('RentListController', function (RentService) {
    const vm = this;
    vm.rents = RentService.getAll();
    vm.search = text => {
        vm.rents = RentService.getAll({text});
    };
});