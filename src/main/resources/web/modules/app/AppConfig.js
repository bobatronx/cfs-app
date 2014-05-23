(function(define){
  'use strict'

  define([], function() {

    var AppConfig = function($routeProvider) {

      $routeProvider.when('/home', {
        templateUrl: 'modules/home/tmpl/home.html',
        controller: 'homeController'
      }).otherwise({
        redirectTo: '/home'
      });
    };

    return ['$routeProvider', AppConfig];
  });
}(define));