(function() {
  'use strict';

  angular
    .module('app')
    .config(routeConfig);

  function routeConfig($routeProvider) {
    $routeProvider.
    when('/',{
      templateUrl: 'app/main/main.html'
    }).
    when('/index',{
      templateUrl: 'app/main/main.html'
    }).
    when('/Product1',{
      templateUrl: 'app/product/PlaceT1.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/Product2',{
      templateUrl: 'app/product/PlaceT2.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/Product3',{
      templateUrl: 'app/product/PlaceT3.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/Product4',{
      templateUrl: 'app/product/PlaceT4.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/ProductItem/:id',{
      templateUrl: 'app/product/PlaceItem.html',
      controller: 'viewProductController',
      controllerAs: 'vm'
    }).
    /*when('/shoppingCart/:id',{
      templateUrl: 'app/shoppingcart/shoppingCart.html',
      controller: 'showShoppingCartController',
      controllerAs: 'vm'
    }).*/
    /*when('/shoppingCart',{
      templateUrl: 'app/shoppingcart/shoppingCart.html',
      controller: 'shoppingCartController',
      controllerAs: 'vm'
    }).*/
    when('/ManageProduct',{
      templateUrl: 'app/product/managePlace.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/addProduct',{
        templateUrl: 'app/product/AEPlace.html',
        controller: 'addProductController',
        controllerAs: 'addProductController'
      }).
      when('/editProduct/:id',{
        templateUrl: 'app/product/AEPlace.html',
        controller: 'editProductController',
        controllerAs: 'editProductController'
      }).
    when('/About',{
      templateUrl: 'app/Extras/about.html'
    }).
    when('/addU',{
      templateUrl: 'app/user/userList.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).
    when('/addUser',{
      templateUrl: 'app/user/AEUser.html',
      controller: 'addUserController',
      controllerAs: 'addUserController'
    }).
    when('/editU',{
      templateUrl: 'app/user/userList.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).
    when('/editUser/:id',{
      templateUrl: 'app/user/AEUser.html',
      controller: 'editUserController',
      controllerAs: 'editUserController'
    }).
    when('/listUser',{
      templateUrl: 'app/user/userList.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).
    when('/editP',{
      templateUrl: 'app/product/PlaceT1.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/DelP',{
      templateUrl: 'app/product/PlaceT1.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/addP',{
      templateUrl: 'app/product/PlaceT1.html',
      controller: 'listProductController',
      controllerAs: 'vm'
    }).
    when('/memberList',{
      templateUrl: 'app/user/userList.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).
    when('/ManageMember',{
      templateUrl: 'app/user/ManageUser.html',
      controller: 'listUserController',
      controllerAs: 'vm'
    }).

    // when('/addProduct',{
    //   templateUrl: 'app/product/editPlace.html',
    //   controller: 'addProductController',
    //   controllerAs: 'addProductController'
    // }).
    // when('/editProduct/:id',{
    //   templateUrl: 'app/product/editPlace.html',
    //   controller: 'editProductController',
    //   controllerAs: 'editProductController'
    // }).
    // when('/listProduct',{
    //   templateUrl: 'app/product/placeList.html',
    //   controller: 'listProductController',
    //   controllerAs: 'vm'
    // }).
    // when('/shoppingCart/:id',{
    //   templateUrl: 'app/shoppingcart/shoppingCart.html',
    //   controller: 'showShoppingCartController',
    //   controllerAs: 'vm'
    // }).
    // when('/location',{
    //   templateUrl: 'app/CheckIn/Location.html',
    //   controller: 'locationController'
    // }).
    otherwise({redirectTo: '/'});

  }

})();
