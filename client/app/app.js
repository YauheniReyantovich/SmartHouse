(function () {
    'use strict';

    angular.module('sample', ['ui.router', 'ngStorage', 'ngTable',
        'ngResource', 'toaster', 'ui.bootstrap', 'dialogs.main', 'ui.sortable'])
        .config(function ($httpProvider) {
            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
        })
        .run(['$rootScope', '$state', '$stateParams', 'authorization', '$transitions', 'ui',
            function ($rootScope, $state, $stateParams, authorization, $transitions, ui) {
                $transitions.onStart({}, function (trans) {
                    var to = trans.to();
                    var $state = trans.router.stateService;

                    if (to.name === 'login' && !ui.stateChanged) return;

                    if (!authorization.isAuthenticated()) {
                        return authorization.getUser().then(function success() {
                            authorization.authenticated = true;
                        }, function err() {
                            return $state.target('login');
                        });
                    }

                    return ui.checkChanges();
                });

                angular.extend($rootScope, {
                    logout: function () {
                        ui.checkChanges().then(function(state) {
                            if (state) {
                                authorization.logout().then(function () {
                                    $state.go('login');
                                    authorization.authenticated = false;
                                });
                            }
                        });
                    }
                })
            }]);
}());
