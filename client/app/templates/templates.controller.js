(function () {
    'use strict';

    /** @ngInject */
    function TemplatesController(Template, ui, $uibModal) {
        this.Template = Template;
        this.ui = ui;
        this.activate();
        this.uibModal = $uibModal;
    }

    TemplatesController.prototype.activate = function () {
        var _this = this;
        this.Template.query(function (templates) {
            _this.templates = templates;
        });
    };

    TemplatesController.prototype.removeTemplate = function (template) {
        var _this = this;
        this.ui.showConfirmation('Do you want to delete template \'' + template.name + '\'?').result.then(function () {
            _this.Template.delete({ templateId: template.id }, function () {
                var index = _this.templates.indexOf(template);
                _this.templates.splice(index, 1);
                _this.ui.notifySuccess('Template deleted successfully');
            }, function () {
                _this.ui.notifyError('Error while deleting template');
            });
        });
    };


    TemplatesController.prototype.openModal = function () {
        var _this = this;
        this.uibModal.open({
            templateUrl: '/app/templates/create-template-popup.html',
            controller: function ($uibModalInstance, entity) {
                this.entity = entity;

                this.cancel = function () {
                    $uibModalInstance.dismiss('cancel');
                };

                this.createTemplate = function (template) {
                    template.$save(function (template) {
                        _this.ui.notifySuccess('Template created successfully');
                        _this.templates.push(template);
                    }, function () {
                        _this.ui.notifyError('Error while creating template')
                    });

                    $uibModalInstance.close();
                }
            },
            resolve: {
                entity: function () {
                    return new _this.Template();
                }
            },
            controllerAs: 'ctrl'
        }).result.catch(function () { });
    };

    TemplatesController.$inject = ['Template', 'ui', '$uibModal'];
    angular.module('sample').controller('TemplatesCtrl', TemplatesController);
}());