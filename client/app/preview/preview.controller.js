(function () {
    'use strict';

    /** @ngInject */
    function PreviewController($state) {
        this.$state = $state;
    }

    PreviewController.prototype.logIn = function(){
        this.$state.go('login');
    };

    PreviewController.prototype.newAccount = function(){

    };

    PreviewController.$inject = ['$state', 'authorization'];
    angular.module('sample').controller('PreviewCtrl', PreviewController);
}());