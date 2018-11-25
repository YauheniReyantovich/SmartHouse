(function() {
    'use strict';

    angular.module('sample').config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider.state('preview', {
                url: '/',
                templateUrl: 'app/preview/preview.html',
                controller: 'PreviewCtrl',
                controllerAs: 'ctrl'
            });
            $urlRouterProvider.otherwise('/preview');
        }]);
}());