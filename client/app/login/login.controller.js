(function () {
    'use strict';

    function LoginController(ui, authorization, $rootScope, $state) {
        this.ui = ui;
        this.authorization = authorization;
        this.$rootScope = $rootScope;
        this.$state = $state;
    }

    LoginController.prototype.login = function (username, password) {
        var _this = this;
        this.authorization.authenticate(username, password).then(function() {
            delete _this.errorMessage;
            _this.authorization.authenticated = true;
            _this.$state.go('sensors');
        }).catch(function() {
            _this.ui.notifyError('Invalid username or password');
        })
    };

    LoginController.$inject = ['ui', 'authorization', '$rootScope', '$state'];
    angular.module('sample').controller('LoginCtrl', LoginController);
}());