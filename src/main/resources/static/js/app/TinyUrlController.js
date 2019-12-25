'use strict'

var module = angular.module('tinyurl.controller', []);
module.controller("TinyUrlController", [
		"$scope",
		"TinyUrlService",
		function($scope, TinyUrlService) {

			$scope.getLongUrl = function() {
				var Favs = TinyUrlService.getLongUrl($scope.tinyUrl)
				Favs.then(function() {

					$scope.long_res_data = Favs.$$state.value[0].data;

					console.log("W: "
							+ JSON.stringify(Favs.$$state.value[0].data));

				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				});
			}

			$scope.generateTinyUrl = function() {
				var Favs = TinyUrlService.generateTinyUrl($scope.longUrl)
				Favs.then(function() {

					$scope.res_data = Favs.$$state.value[0].data;
					console.log("W: "
							+ JSON.stringify(Favs.$$state.value[0].data));

				}, function(reason) {
					console.log("error occured" + reason);
				}, function(value) {
					console.log("no callback");
				});
			}
		} ]);