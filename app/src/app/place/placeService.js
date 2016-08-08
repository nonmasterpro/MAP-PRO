(function() {
'use strict'
  angular
    .module('app')
    .factory('placeService',placeService)
    .factory('totalCalService',totalCalService)
    .factory('removePlaceService',removePlaceService)
    .factory('queryPlaceService',queryPlaceService);



  /** @ngInject */
  function placeService($resource){
    return $resource('/place/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }
    });

  }

  /** @ngInject */
  function removePlaceService($resource){
    return $resource('/place/remove', {}, {
      update: {
        method: 'DELETE' // this method issues a PUT request
      }
    });

  }


  /** @ngInject */
  function totalCalService() {
    this.getTotalNetPrice = function (products) {
        var output = 0.0;

        for (var index = 0; index < products.length;index++) {
            var product = products[index];
            output += parseFloat(product.netPrice);
        }
        return output;
    }
}


  /** @ngInject */
  function queryPlaceService($resource){
    return $resource('/getPlace/?name=:name',
        {query:{method:'GET',params:{name:''},isArray:true}

        });
}
})();
