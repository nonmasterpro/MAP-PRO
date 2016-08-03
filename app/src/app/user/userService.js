/**
 * Created by love_ on 7/31/2016.
 */
(function () {
  'use strict';
  angular
    .module('app')
    .factory('userService', userService)
    .factory('queryUserService', queryUserService);

  /** @ngInject */
  function userService($resource) {
    return $resource('/customer/:id', {id: '@_id'}, {
      update: {
        method: 'PUT' // this method issues a PUT request
      }
    });

  }


  /** @ngInject */
  function queryUserService($resource) {
    return $resource('/getUser/?name=:name',
      {
        query: {
          method: 'GET', params: {name: ''}, isArray: true
        }
      });
  }
})();

