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
                    var to = trans.to().name;
                    var from = trans.from().name;
                    var $state = trans.router.stateService;

                    if(authorization.isAuthenticated()) {
                        if(to !== 'sensors' && to !== 'scripts'){
                            return $state.target('sensors');
                        }
                    }else {
                        if(to === 'sensors' || to === 'scripts'){
                            if(from === 'login') {
                                return authorization.getUser().then(function success() {
                                    authorization.authenticated = true;
                                }, function err() {
                                    return $state.target('login');
                                });
                            }else {
                                return $state.target('login');
                            }
                        }
                        // if(to === 'login' || to === 'preview'){
                        //     return;
                        // }else {
                        //     return $state.target('preview');
                        // }
                    }
                    //
                    // if (to.name === 'login' && !ui.stateChanged) return;
                    //
                    // if (!authorization.isAuthenticated()) {
                    //     return authorization.getUser().then(function success() {
                    //         authorization.authenticated = true;
                    //     }, function err() {
                    //         return $state.target('login');
                    //     });
                    // }
                    //
                    // return ui.checkChanges();
                });

                angular.extend($rootScope, {
                    logout: function () {
                        ui.checkChanges().then(function(state) {
                            if (state) {
                                authorization.logout().then(function () {
                                    $state.go('preview');
                                    authorization.authenticated = false;
                                });
                            }
                        });
                    }
                })
            }]);
}());
