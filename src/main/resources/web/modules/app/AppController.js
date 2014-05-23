(function(define){
  'use strict';

  var dependencies = [];

  define(dependencies, function() {
    var AppController = function($scope, $http, $log, $window, $location) {
      $scope.app = "App";
    };

    return ['$scope', '$http', '$log', '$window', '$location', AppController];
  });
}(define));