(function () {
  'use strict';

  angular
    .module('app')
    .controller('addPlaceController', addPlaceController)
    .controller('listPlaceController', listPlaceController)
    .controller('viewPlaceController',viewPlaceController)
    .controller('reviewController',reviewController)
    .controller('editPlaceController', editPlaceController);


  /** @ngInject */
  function reviewController($scope) {

    $scope.datas = [];
    $scope.data = {};
    $scope.addData = function (data) {
      datas.push($scope.data);
      $scope.data = {};
    }

  }



  /** @ngInject */
  function addPlaceController($http,$scope, $location, $rootScope, placeService,$window) {
    var vm = $scope;
    vm.place = {};
    vm.addPerson = true;
    vm.editPerson = false;
    vm.addPlace = function (flowFiles) {
      placeService.save(vm.place, function (data) {
        // after adding the object, add a new picture
        // get the product id which the image will be addded
        var placeid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {placeid: placeid};
        flowFiles.upload();

        vm.addSuccess = true;
        alert("Add success!");
        $window.location.href = '#/ManagePlace';

      });
    }

    vm.clearSearch = function() {
      vm.ImageInput = "";
    }

  }


  /** @ngInject */
  function listPlaceController(removePlaceService, $scope,$rootScope, placeService, $route,$window, queryPlaceService ,cartManagement) {
    var vm = this;
    //$http.get("/product/").success(function (data) {
    vm.queryPromise = placeService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
     vm.places = data;
    }).$promise;


    //$scope.$on('$locationChangeStart', function () {
    //  $rootScope.addSuccess = false;
    //  $rootScope.editSuccess = false;
    //  $rootScope.deleteSuccess = false;
    //});

    vm.deletePlace = function (Id) {
      var answer = confirm("Do you want to delete ?");
      if (answer) {
        removePlaceService.remove({id: Id},function () {

          //$rootScope.deleteSuccess = true;
          //alert(1);
          alert("Delete success!");
          $window.location.reload();
        }, function(error) {
          console.log(error);
          $window.location.reload();
        })

      }
    }

    vm.searchPlace = function (name) {
      queryPlaceService.query({name: name}, function (data) {
        vm.places = data;
      });
    }

    //vm.addToCart = function (product) {
    //  $rootScope.HeadSuccess=null;
    //  $rootScope.HeadFail=null;
    //  $rootScope.result=null;
    //  $rootScope.error=null;
    //  product.images = null;
    //  cartManagement.addToCart({id:product.id},$rootScope.shoppingCart, function (shoppingCart) {
    //    //success event
    //    $rootScope.shoppingCart = shoppingCart;
    //    $rootScope.HeadSuccess ="Status";
    //    $rootScope.result = "Add Product Success";
    //
    //  }, function (error) {
    //    // fail event
    //    if(error.status=="401"){
    //      $rootScope.HeadFail ="Warning";
    //      $rootScope.error="Add Product Fail";
    //    }
    //  })
    //  $route.reload();
    //}

  }


  /** @ngInject */
  function viewPlaceController($routeParams, placeService ,$rootScope ,cartManagement ,$route) {
    var vm = $rootScope;
    var id = $routeParams.id;
    vm.imagePlace=null;
    vm.placeDetail=null;
    placeService.get({id:id},function (data) {
      vm.placeDetail=data;
      vm.imagePlace = vm.placeDetail.images;
    })
/*    vm.addToCart = function (place) {
      $rootScope.HeadSuccess=null;
      $rootScope.HeadFail=null;
      $rootScope.result=null;
      $rootScope.error=null;
      product.images = null;
      cartManagement.addToCart({id:product.id},$rootScope.shoppingCart, function (shoppingCart) {
        //success event
        $rootScope.shoppingCart = shoppingCart;
        $rootScope.HeadSuccess ="Status";
        $rootScope.result = "Add Product Success";

      }, function (error) {
        // fail event
        if(error.status=="401"){
          $rootScope.HeadFail ="Warning";
          $rootScope.error="Add Product Fail";
        }
      })
      $route.reload();
    }*/

  }

  /** @ngInject */
  function editPlaceController( $http, $scope, $routeParams,$window, $location, $rootScope, placeService) {
    var vm = $scope;
    vm.addPlace = false;
    vm.editPlace = true;
    var id = $routeParams.id;
    placeService.get({id:id},
      // success function
     function(data){
       vm.place=data;
     }
    )


    vm.editPlace = function (flowFiles) {
      //$http.put("/product", $scope.product).then(function () {
      placeService.update({id: vm.place.id}, vm.place, function (data) {
        var placeid = data.id;
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {placeid:placeid};
        flowFiles.upload();

        vm.editSuccess = true;
alert("Edit success!");
        $window.location.href = '#/ManagePlace';
      });
    }

    vm.removeImage = function(pdId, imgId) {
      var r = confirm("Are you sure?");
      if (r == true) {
        $http.delete("http://localhost:8080/productImage/remove?productid="+pdId+"&imageid="+imgId).then(function () {
          $http.get("http://localhost:8080/product/" + pdId).success(function (data) {
            vm.place = data;
          });
        }, function(){
          console.log("FAILED");
        });
      }
    }
  }
})();
