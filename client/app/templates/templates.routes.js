(function () {
    'use strict';

    angular.module('sample').config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $stateProvider.state('templates', {
                url: '/',
                templateUrl: 'app/templates/templates.html',
                controller: 'TemplatesCtrl',
                controllerAs: 'ctrl'
            }).state('view-template', {
                url: '/templates/:id/view',
                templateUrl: 'app/templates/template-view.html',
                controller: 'TemplateCtrl',
                controllerAs: 'ctrl',
                resolve: {
                    entity: function ($stateParams, Template) {
                        return Template.get({ templateId: $stateParams.id }).$promise
                    }
                }
            }).state('edit-template', {
                url: '/templates/:id/edit',
                templateUrl: 'app/templates/template.html',
                controller: 'TemplateCtrl',
                controllerAs: 'ctrl',
                resolve: {
                    entity: function ($stateParams, Template) {
                        return Template.get({ templateId: $stateParams.id }).$promise
                    }
                }
            });

            $urlRouterProvider.otherwise('/');
        }]);
}());