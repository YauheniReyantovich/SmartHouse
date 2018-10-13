(function () {
    'use strict';

    angular.module('sample').factory('ui', ['toaster', 'dialogs', '$q', function (toaster, dialogs, $q) {
        return {
            notifySuccess: function (message) {
                toaster.pop({type: 'success', body: message, timeout: 1500})
            },

            notifyError: function (message) {
                toaster.pop({type: 'error', body: message, timeout: 1500})
            },

            clear: function () {
                toaster.clear()
            },

            showConfirmation: function(message) {
                return dialogs.confirm('Confirmation', message, {size: 'md'});
            },

            checkChanges: function () {
                var _this = this;
                var deferred = $q.defer();

                if (this.stateChanged) {
                    _this.showConfirmation('Do you want continue without saving?').result.then(function () {
                        _this.stateChanged = false;
                        deferred.resolve(true);
                    }, function() {
                        deferred.resolve(false);
                    })
                } else {
                    deferred.resolve(true);
                }

                return deferred.promise;
            }
        };
    }]);

}());