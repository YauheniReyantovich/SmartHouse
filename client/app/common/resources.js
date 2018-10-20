(function () {
    'use strict';

    angular.module('sample').factory('Template', function ($resource) {
        return $resource('templates/:templateId', { templateId: '@templateId' }, {
            'update': { method: 'PUT' },
            'findTemplateItems': {
                method: 'GET',
                isArray: true,
                url: 'templates/:templateId/items',
                params: {
                    templateId: '@templateId'
                }
            },
            'saveTemplateItems': {
                method: 'POST',
                isArray: true,
                url: 'templates/:templateId/items',
                params: {
                    templateId: '@templateId'
                }
            }
        });
    });

    angular.module('sample').factory('TemplateItem', function ($resource) {
        return $resource('template-items/:itemId', { itemId: '@itemId' }, {
            'update': { method: 'PUT' }
        });
    });

}());