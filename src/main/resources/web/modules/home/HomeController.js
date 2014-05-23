(function(define) {
  'use strict';

  var dependencies = [];

  define(dependencies, function() {
    var HomeController = function($scope) {
      $scope.successful = "SUCCESS";
    };

    return ['$scope', HomeController];
  });

}(define));