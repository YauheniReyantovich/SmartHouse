(function() {
    'use strict';

    angular.module('sample').config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider.state('login', {
                url: '/login',
                templateUrl: 'app/login/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'ctrl'
            });
            $urlRouterProvider.otherwise('/templates');
        }]);
}());