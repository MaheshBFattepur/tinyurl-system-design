'use strict'

var demoApp = angular.module('tinyurl', [ 'ui.bootstrap', 'tinyurl.controller',
		'tinyurl.services' ]);
demoApp.constant("CONSTANTS", {
	generateTinyUrl : "/api/generateTinyUrl",
	getLongUrl : "/api/getLongUrl"
});