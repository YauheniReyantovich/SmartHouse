(function () {
    'use strict';

    /** @ngInject */
    function AuthorizationService($http) {
        this.$http = $http;
        this.authenticated = false;
    }

    AuthorizationService.prototype.isAuthenticated = function() {
        return this.authenticated;
    };

    AuthorizationService.prototype.getUser = function() {
        return this.$http.get('/auth/user');
    };

    AuthorizationService.prototype.authenticate = function(username, password) {
        var data = 'j_username=' + username + '&j_password=' + password;
        return this.$http({
            method: 'POST',
            url: '/j_spring_security_check',
            data: data,
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        });
    };

    AuthorizationService.prototype.logout = function() {
        return this.$http.get('/logout');
    };

    AuthorizationService.$inject = ['$http'];
    angular.module('sample').service('authorization', AuthorizationService);
}());