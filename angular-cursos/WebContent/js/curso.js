/**
 * 
 */

var app = angular.module('cursos', ['ngResource']);
/*
app.controller('cursosTabla', function($scope, $http) {
	$http({
		url: 'http://localhost:8080/cursos-services/zaix/cursos/all',
		method: 'GET'
	}).success(function(data) {
		$scope.cursos = data;
	})	
})
*/


app.controller('cursosTabla', function($scope, $http) {
	$http.get("http://localhost:8080/cursos-services/zaix/cursos/all").then(function (response) {
	      $scope.cursos = response.data;
	  });
})