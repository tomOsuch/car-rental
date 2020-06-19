angular.module('app')
.controller('RentEditController', function ($routeParams, $location, Rent, RentService, CategoryService) {
    const vm = this;
    const  rentId = $routeParams.rentId;
    if (rentId){
        vm.rent = RentService.get(rentId);
    } else {
        vm.rent = new Rent();
    }
    vm.categoryName = CategoryService.getAllNames();

    const  saveCallback = () => {
        $location.path(`/rent-edit/${vm.rent.id}`);
    };
    const  errorCallback = err => {
        vm.msg = `Błąd zapisu: ${err.data.message}`;
    };

    vm.save = () => {
        console.log(vm.rent);
        RentService.save(vm.rent)
            .then(saveCallback)
            .catch(errorCallback)
    };
    const updateCallback = response => vm.msg = 'Zapisano zmiany';
    vm.update = () => {
        RentService.update(vm.rent)
            .then(updateCallback)
            .catch(errorCallback);
    };
});