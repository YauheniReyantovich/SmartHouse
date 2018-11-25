(function () {
    'use strict';

    /** @ngInject */
    function ScriptsController(ui, $state, $http) {
        this.http = $http;
        this.ui = ui;
        this.activate();
        this.state = $state;
    }

    ScriptsController.prototype.toSensors = function(){
        this.state.go('sensors');
    };

    ScriptsController.prototype.checkControl = function(index, value){
        this.http.post('/controller/changeState', {index: index, value: value === undefined ? false : value});
    };

    ScriptsController.prototype.newScript = function(newscript){
        console.log(newscript);
        this.http.post('/script/newScript', newscript);
    };

    ScriptsController.prototype.activate = function () {
        var _this = this;
        this.http.get('/script/scripts').then(
            function (response) {
                _this.scripts = response.data.scripts;
                _this.sensors = response.data.sensors;
            },
            function (error) {
                this.ui.notifyError(error);
                alert('get scripts error');
            }
        );
    };

    ScriptsController.$inject = ['ui', '$state', '$http'];
    angular.module('sample').controller('ScriptsCtrl', ScriptsController);
}());