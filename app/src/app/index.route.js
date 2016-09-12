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
    when('/Place1',{
      templateUrl: 'app/place/managePlace.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/Place2',{
      templateUrl: 'app/place/PlaceT2.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/Place3',{
      templateUrl: 'app/place/PlaceT3.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/Place4',{
      templateUrl: 'app/place/PlaceT4.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/PlaceItem/:id',{
      templateUrl: 'app/place/PlaceItem.html',
      controller: 'viewPlaceController',
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
    when('/ManagePlace',{
      templateUrl: 'app/place/managePlace.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/addPlace',{
        templateUrl: 'app/place/AEPlace.html',
        controller: 'addPlaceController',
        controllerAs: 'addPlaceController'
      }).
      when('/editPlace/:id',{
        templateUrl: 'app/place/AEPlace.html',
        controller: 'editPlaceController',
        controllerAs: 'editPlaceController'
      }).
    when('/About',{
      templateUrl: 'app/Extras/about.html'
    }).
    //when('/addU',{
    //  templateUrl: 'app/user/userList.html',
    //  controller: 'listUserController',
    //  controllerAs: 'vm'
    //}).
    when('/addUser',{
      templateUrl: 'app/user/AEUser.html',
      controller: 'addUserController',
      controllerAs: 'addUserController'
    }).
    when('/editU',{
      templateUrl: 'app/user/ManageUser.html',
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
      templateUrl: 'app/place/PlaceT1.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/DelP',{
      templateUrl: 'app/place/PlaceT1.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/addP',{
      templateUrl: 'app/place/PlaceT1.html',
      controller: 'listPlaceController',
      controllerAs: 'vm'
    }).
    when('/memberList',{
      templateUrl: 'app/user/ManageUser.html',
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
