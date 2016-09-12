/**
 * Created by love_ on 7/31/2016.
 */
(function () {
  'use strict';

  angular
    .module('app')
    .controller('listUserController', listUserController)
    .controller('registerController', registerController)
    .controller('addUserController', addUserController)
    .controller('editUserController', editUserController);

  /** @ngInject */
  function listUserController(userService, queryUserService, $window, $location,$rootScope) {
    var vm = this;
    vm.queryPromise = userService.query(function (data) {
      vm.users = data;
    }).$promise;

    //$scope.$on('$locationChangeStart', function () {
    //  $rootScope.addSuccess = false;
    //  $rootScope.editSuccess = false;
    //  $rootScope.deleteSuccess = false;
    //});

    vm.deleteUser = function (id) {
      var answer = confirm("Do you want to delete ?");
      if (answer) {
        userService.delete({id: id}, function () {
          $rootScope.deleteSuccess = true;
          //$route.reload();
          alert("Delete success!");
          $window.location.reload();
          //$window.location.reload();
          //$location.path("userList");

        })
      }


    }

    vm.searchUser = function (name) {
      queryUserService.query({name: name}, function (data) {
        vm.users = data;
      });
    }

  }

  /** @ngInject */
  function registerController($http, $location, $rootScope, userService, $route) {
    var vm = this;
    vm.user = {};
    vm.addUser = true;
    vm.editUser = false;
    vm.register = function () {
      userService.save(vm.user, function () {
        $rootScope.addSuccess = true;
        $location.path("userList");
      });


    };

  }

  /** @ngInject */
  function addUserController($http,$scope, $location, $rootScope, userService,$window) {
    var vm = $scope;
    vm.user = {};
    vm.addUser = true;
    vm.editUser = false;
    vm.addUser = function (flowFiles) {
      userService.save(vm.user, function (data) {
        // after adding the object, add a new picture
        // get the product id which the image will be addded
        var userid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/userImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {userid: userid};
        flowFiles.upload();

        vm.addSuccess = true;
        alert("Add success!");
        $window.location.href = '#/ManageMember';

      });
    }

    vm.clearSearch = function() {
      vm.ImageInput = "";
    }

  }

  /** @ngInject */
  function editUserController($route,$window, $routeParams, $location, $rootScope, userService, $http,$scope ) {

    var vm = $scope;
    vm.addUser = false;
    vm.editUser = true;
    var id = $routeParams.id;
    userService.get({id:id},
      // success function
      function(data){
        vm.user=data;1
      }
    )


    vm.editUser = function (flowFiles) {

      //$http.put("/product", $scope.product).then(function () {
      userService.update({id: vm.user.id}, vm.user, function (data) {
        var userid = data.id;
        flowFiles.opts.target = 'http://localhost:8080/userImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {userid:userid};
        flowFiles.upload();

        vm.editSuccess = true;
        alert("Edit success!");
        $window.location.href = '#/ManageMember';
      });
    }



    /*var vm = this;
    var id = $routeParams.id;
    userService.get({id: id},
      // success function
      function (data) {
        vm.user = data;
      }
    );*/

    /* vm.editProduct = function (flowFiles) {  //$http.put("/product", $scope.product).then(function () {
     productService.update({id: vm.product.id}, vm.product, function () {
     var productid = vm.product.id;
     // set location
     flowFiles.opts.target = 'http://localhost:8080/productImage/add';
     flowFiles.opts.testChunks = false;
     flowFiles.opts.query = {productid: productid};
     flowFiles.upload();
     $rootScope.editSuccess = true;
     $location.path("listProduct");
     $route.reload();
     vm.apply();
     });
     };*/
  }
})();
