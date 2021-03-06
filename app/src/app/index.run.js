(function() {
  'use strict';

  angular
    .module('app')
    .run(runBlock)
    .run(runSecurity);

  /** @ngInject */
  function runSecurity($rootScope, $location, $cookies, UserService) {
    var removeErrorMsg = $rootScope.$on('$viewContentLoaded',function () {
      delete $rootScope.error;
    });
    removeErrorMsg();

    $rootScope.hasRole = function (role) {
      if($rootScope.user == undefined){
        return false;
      }
      if($rootScope.user.roles[role]==undefined){
        return false;
      }
      return $rootScope.user.roles[role];
    };
    $rootScope.logout = function () {
      delete $rootScope.user;
      delete $rootScope.authToken;
      delete $rootScope.result;
      delete $rootScope.HeadSuccess;
      $cookies.remove('authToken');
      $location.path("/index")
    };

    /*Try getting valid user from cookie or go to login page */
    var originalPath=$location.path();
    $location.path("/index");
    var authToken = $cookies.get('authToken');
    if(authToken != undefined){
      $rootScope.authToken = authToken;
      UserService.get(function (user) {
        $rootScope.user=user;
        $location.path(originalPath);
      })
    }
    $rootScope.initialized=true;
    $rootScope.shoppingCart = {};
  }

  /** @ngInject */
  function runBlock($log) {

    $log.debug('runBlock end');
  }


})();
