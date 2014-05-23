(function(define, angular) {
  'use strict';

  var dependencies = ['app/AppConfig', 'app/AppController', 'home/HomeModule'];

  define(dependencies, function(AppConfig, AppController, HomeModule) {
    var moduleName = 'module.app';

    angular.module(moduleName, [HomeModule])
      .config(AppConfig)
      .controller("appController", AppController);

    return moduleName;
  });
}(define, angular));