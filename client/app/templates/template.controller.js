(function () {
    'use strict';

    function TemplateController(Template, TemplateItem, ui, entity, sections) {
        this.Template = Template;
        this.TemplateItem = TemplateItem;
        this.ui = ui;
        this.entity = entity;
        this.dataSections = sections;
        this.activate();
    }

    TemplateController.prototype.templateUpdated = function() {
        this.ui.stateChanged = true;
    };

    TemplateController.prototype.activate = function () {
        var _this = this;
        this.sectionOptions = {
            connectWith: ".items",
            stop: function () {
            }
        };

        this.templateOptions = {
            connectWith: ".items",
            handle: '.item-header',
            update: function (e, ui) {
                _this.templateUpdated();
            }
        };

        if (this.entity.id) {
            this.Template.findTemplateItems({ templateId: _this.entity.id }, function (items) {
                _this.items = items;
            });
        }
    };

    TemplateController.prototype.save = function (entity) {
        var _this = this;
        this.Template.update({ templateId: entity.id }, entity, function (entity) {
            _this.entity = entity;
            _this.items.forEach(function(item, index) { item.order = index; });
            _this.Template.saveTemplateItems({ templateId: entity.id }, _this.items, function (result) {
                _this.items = result;
                _this.ui.stateChanged = false;
                _this.ui.notifySuccess('Template items saved successfully');
            }, function () {
                _this.ui.notifyError('Error while saving template item')
            })
        }, function () {
            _this.ui.notifyError('Error while saving template')
        });
    };

    TemplateController.prototype.removeItem = function (item) {
        var _this = this;
        this.ui.showConfirmation('Do you want to delete template item ?').result.then(function () {
            if (item.id) {
                _this.TemplateItem.delete({itemId: item.id}, function () {
                    var index = _this.items.indexOf(item);
                    _this.items.splice(index, 1);
                    _this.ui.notifySuccess('Template deleted successfully');
                }, function () {
                    _this.ui.notifyError('Error while deleting template')
                });
            } else {
                var index = _this.items.indexOf(item);
                _this.items.splice(index, 1);
            }
        });
    };

    TemplateController.$inject = ['Template', 'TemplateItem', 'ui', 'entity'];
    angular.module('sample').controller('TemplateCtrl', TemplateController);
}());