(function () {
    'use strict';

    angular.module('sample').config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider.state('scripts', {
                url: '/scripts',
                templateUrl: 'app/scripts/script.html',
                controller: 'ScriptsCtrl',
                controllerAs: 'ctrl'
            });

            $urlRouterProvider.otherwise('/preview');
        }]);
}());