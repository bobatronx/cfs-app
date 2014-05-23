(function() {
  'use strict';

  var angularVersion = '1.3.0-beta.8';

  require.config({
    priority: 'angular',
    paths: {
      'angular': 'angularjs/' + angularVersion + '/angular',
      'bootstrap': 'bootstrap/3.1.1/bootstrap.min',
      'ngRoute': 'angularjs/' + angularVersion + '/angular-route',
      'ngSanitize': 'angularjs/' + angularVersion + '/angular-sanitize',
      'ngResource': 'angularjs/' + angularVersion + '/angular-resource',
      'ngCookies': 'angularjs/' + angularVersion + '/angular-cookies',
      'ngStrap': 'angular-strap/2.0.2/angular-strap.min',
      'domReady': 'requirejs-domready/2.0.1/domReady',
      'app': 'modules/app',
      'appModule': 'modules/app/AppModule',
      'home': 'modules/home'
    },
    shim: {
      'angular': {
        exports: 'angular',
        deps: []
      },
      'bootstrap': {
        deps: ['angular']
      },
      'ngRoute': {
        deps: ['angular']
      },
      'ngSanitize': {
          deps: ['angular']
      },
      'ngResource': {
          deps: ['angular']
      },
      'ngCookies': {
          deps: ['angular']
      },
      'ngStrap': {
          deps: ['angular']
      },
      'appModule': {
        deps: ['angular']
      }
    }
  });

  var dependencies = ['domReady!', 'angular', 'appModule', 'ngRoute',
    'ngSanitize', 'ngResource', 'ngCookies', 'ngStrap'],
    appName = 'CFSWebApp';

  require(dependencies, function(document, angular, AppModule) {
    angular.module(appName, ['ngRoute', 'ngSanitize', 'ngResource', 'ngCookies', 'mgcrea.ngStrap', AppModule]);
    angular.bootstrap(document.getElementsByTagName("body")[0], [appName]);
  });
}());
