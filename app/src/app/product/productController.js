(function () {
  'use strict';

  angular
    .module('app')
    .controller('addProductController', addProductController)
    .controller('listProductController', listProductController)
    .controller('viewProductController',viewProductController)
    .controller('reviewController',reviewController)
    .controller('editProductController', editProductController);


  /** @ngInject */
  function reviewController($scope) {

    $scope.datas = [];
    $scope.data = {};
    $scope.addData = function (datas) {
      datas.push($scope.data);
      $scope.data = {};
    }

  }



  /** @ngInject */
  function addProductController($http,$scope, $location, $rootScope, productService,$window) {
    var vm = $scope;
    vm.product = {};
    vm.addPerson = true;
    vm.editPerson = false;
    vm.addProduct = function (flowFiles) {
      productService.save(vm.product, function (data) {
        // after adding the object, add a new picture
        // get the product id which the image will be addded
        var productid = data.id;
        // set location
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {productid: productid};
        flowFiles.upload();

        vm.addSuccess = true;
        $window.location.href = '#/Product1';

      });
    }

    vm.clearSearch = function() {
      vm.ImageInput = "";
    }

  }


  /** @ngInject */
  function listProductController(removeProductService, $scope,$rootScope, productService, $route,$window, queryProductService ,cartManagement) {
    var vm = this;
    //$http.get("/product/").success(function (data) {
    vm.queryPromise = productService.query(function (data) {
      // $scope.totalNetPrice= totalCalService.getTotalNetPrice(data);
     vm.products = data;
    }).$promise;


    //$scope.$on('$locationChangeStart', function () {
    //  $rootScope.addSuccess = false;
    //  $rootScope.editSuccess = false;
    //  $rootScope.deleteSuccess = false;
    //});

    vm.deleteProduct = function (Id) {
      var answer = confirm("Do you want to delete ?");
      if (answer) {
        removeProductService.remove({id: Id},function () {

          //$rootScope.deleteSuccess = true;
          //alert(1);

          $window.location.href = '#/Product1';
        }, function(error) {
          console.log(error);
          $window.location.href = '#/Product1';
        })

      }
    }

    vm.searchProduct = function (name) {
      queryProductService.query({name: name}, function (data) {
        vm.products = data;
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
  function viewProductController($routeParams, productService ,$rootScope ,cartManagement ,$route) {
    var vm = $rootScope;
    var id = $routeParams.id;
    vm.imageProduct=null;
    vm.productDetail=null;
    productService.get({id:id},function (data) {
      vm.productDetail=data;
      vm.imageProduct = vm.productDetail.images;
    })
    vm.addToCart = function (product) {
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
    }

  }

  /** @ngInject */
  function editProductController( $http, $scope, $routeParams,$window, $location, $rootScope, productService) {
    var vm = $scope;
    vm.addProduct = false;
    vm.editProduct = true;
    var id = $routeParams.id;
    productService.get({id:id},
      // success function
     function(data){
       vm.product=data;
     }
    )


    vm.editProduct = function (flowFiles) {
      //$http.put("/product", $scope.product).then(function () {
      productService.update({id: vm.product.id}, vm.product, function (data) {
        var productid = data.id;
        flowFiles.opts.target = 'http://localhost:8080/productImage/add';
        flowFiles.opts.testChunks = false;
        flowFiles.opts.query = {productid:productid};
        flowFiles.upload();

        vm.editSuccess = true;

        $window.location.href = '#/Product1';

      });
    }

    vm.removeImage = function(pdId, imgId) {
      var r = confirm("Are you sure?");
      if (r == true) {
        $http.delete("http://localhost:8080/productImage/remove?productid="+pdId+"&imageid="+imgId).then(function () {
          $http.get("http://localhost:8080/product/" + pdId).success(function (data) {
            vm.product = data;
          });
        }, function(){
          console.log("FAILED");
        });
      }
    }
  }
})();
