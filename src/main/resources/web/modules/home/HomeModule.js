(function(define, angular){
  'use strict';

  var dependencies = ['home/HomeController'];

  define(dependencies, function(HomeController) {
    var moduleName = 'module.home';

    angular.module(moduleName, [])
      .controller("homeController", HomeController);

    return moduleName;
  });
}(define, angular));