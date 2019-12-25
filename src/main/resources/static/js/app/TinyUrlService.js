'use strict'

angular.module('tinyurl.services', []).factory('TinyUrlService',
		[ "$http", "$q", "CONSTANTS", function($http, $q, CONSTANTS) {
			var service = {};
			service.getLongUrl = function(tinyUrl) {
				var url = CONSTANTS.getLongUrl + "?tinyUrl=" + tinyUrl;

				var promise1 = $http.get(url);
				var deferred = $q.defer();
				return $q.all([ promise1 ]).then(function(response) {
					// promise is fulfilled
					deferred.resolve(response);
					// promise is returned
					return deferred.promise;
				}, function(response) {
					// the following line rejects the
					// promise
					deferred.reject(response);
					// promise is returned
					return deferred.promise;
				});

			}
			service.generateTinyUrl = function(longUrl) {
				var url = CONSTANTS.generateTinyUrl + "?longUrl=" + longUrl;

				var promise1 = $http.post(url);
				var deferred = $q.defer();
				return $q.all([ promise1 ]).then(function(response) {
					// promise is fulfilled
					deferred.resolve(response);
					// promise is returned
					return deferred.promise;
				}, function(response) {
					// the following line rejects the
					// promise
					deferred.reject(response);
					// promise is returned
					return deferred.promise;
				});
			}
			return service;
		} ]);