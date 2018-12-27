(function () {
    'use strict';

    /** @ngInject */
    function SensorsController(ui, $state, $http) {
        this.http = $http;
        this.ui = ui;
        this.activate();
        this.state = $state;
    }

    SensorsController.prototype.someFunction = function(){
        console.log(this.Template);
        var _this = this;
        this.http.get('/sensor/sensors').then(
            function (resp) {
                console.log(resp.data);
                console.log(resp.data.someField);
            },
            function () {
                alert('error')
            }
        )
    };

    SensorsController.prototype.toScripts = function(){
        this.state.go('scripts');
    };

    SensorsController.prototype.checkControl = function(index, value){
        this.http.post('/controller/changeState', {index: index, value: value === undefined ? false : value});
    };

    SensorsController.prototype.newSensor = function(newsensor){
        var _this = this;
        this.http.post('/sensor/newSensor', newsensor).then(
            function (response) {
                _this.sensors = response.data;
            },
            function (error) {
                this.ui.notifyError(error);
                alert('post sensor error');
            }
        );
    };

    SensorsController.prototype.activate = function () {
        var _this = this;
        this.http.get('/sensor/sensors').then(
            function (response) {
                _this.sensors = response.data;
            },
            function (error) {
                this.ui.notifyError(error);
                alert('get sensors error');
            }
        );
    };

    SensorsController.$inject = ['ui', '$state', '$http'];
    angular.module('sample').controller('SensorsCtrl', SensorsController);
}());