/**
 * Ejemplo de consumo servicio REST utilizando ng-resource : http://localhost:8080/angular-cursos/zaix/cursosng.html
 */

/*
 * Modulo principal [Dependencias = servicios, controladores]
 */

var cursos = angular.module('cursos', ['ngRoute','cursos.services','cursos.control']);
/*
 * Configuracion rutas
 */

cursos.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/lista', {templateUrl: 'listE.html', controller: 'estudianteslist'});
	$routeProvider.when('/crear', {templateUrl: 'createE.html', controller: 'estudiantecrear'});
	$routeProvider.when('/editar/:id', {templateUrl: 'editE.html', controller: 'estudianteeditar'});
	$routeProvider.otherwise({redirectTo: '/lista'});
}	
]);
	
/*
 * Servicios de cursos modulo [Dependencias = ngResorce]
 */

var services = angular.module('cursos.services', ['ngResource']);
//Servicio todos los cursos
services.factory('cursosall', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/all', {}, {
		query:{ method:'GET', params:{}, isArray: true }
	})
});
//Servicio todos los estudiantes
services.factory('estudiantesall', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/estudiantes/all', {}, {
		query:{ method:'GET', params:{}, isArray: true }
	})
});
//Servicio crear estudiante
services.factory('estudiantenew', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/registro', {}, {
		create:{ method:'POST'}
	})
});
//Servicio eliminar estudiante
services.factory('estudiantedel', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/remove/:id', {}, {
		delete:{ method:'DELETE', params:{id: '@id'}}
	})
});
//Servicio estudiante por id
services.factory('estudianteid', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/find/:id', {}, {
		show:{ method:'GET', params:{id: '@id'}}
	})
});
//Servicio ACTUALIZAR estudiante
services.factory('estudianteupd', function($resource){
	return $resource('http://localhost:8080/cursos-services/zaix/cursos/modify/:id', {}, {
		update:{ method:'PUT', params:{id: '@id'}}
	})
});
/*
 * Controladores aplicación modulo [No dependencies]
 */
var cursoscon = angular.module('cursos.control', []);
//Controlador lista de cursos
cursoscon.controller('cursoslist',['$scope', 'cursosall', '$location', function($scope, cursosall, $location){
	$scope.cursos = cursosall.query();
	
	$scope.create = function(){
		$location.path('/crear')
	}
	
	$scope.lista = function(){
		$location.path('/lista')
	}
}]);
//controlador lista de estudiantes 
cursoscon.controller('estudianteslist',['$scope', 'estudiantesall', '$location', 'estudiantedel', function($scope, estudiantesall, $location, estudiantedel){
	$scope.removeest = function(estId){
		estudiantedel.delete({ id:estId })
		$scope.est = estudiantesall.query();
	}
	
	$scope.upd = function(estId){
		$location.path('/editar/' + estId);
	}
	
	$scope.est = estudiantesall.query();
}]);
//controlador nuevo estudiante
cursoscon.controller('estudiantecrear',['$scope', 'estudiantenew', 'cursosall', '$location', function($scope, estudiantenew, cursosall, $location){
	$scope.edades = new Array(26);
	for (var int = 0; int < $scope.edades.length; int++) {
		$scope.edades[int] = int + 15 ;
	}
	$scope.cursos = cursosall.query();
	$scope.createStudent = function(){
		estudiantenew.create($scope.estudiante);
		$location.path('/lista');
	}
}]);
//controlador editar estudiante
cursoscon.controller('estudianteeditar',['$scope', 'cursosall', '$routeParams', '$location','estudianteid','estudianteupd', function($scope, cursosall, $routeParams, $location, estudianteid, estudianteupd){
	$scope.edades = new Array(26);
	for (var int = 0; int < $scope.edades.length; int++) {
		$scope.edades[int] = int + 15 ;
	}
	$scope.cursos = cursosall.query();
	$scope.param = $routeParams.id;
	$scope.est = estudianteid.show({ id:$routeParams.id });
	$scope.estudiante = estudianteid.show({ id: $routeParams.id });
	$scope.cancelar = function(){
		$location.path('/lista');
	}
	
	$scope.actualEst = function(){
		estudianteupd.update({id:$routeParams.id},$scope.estudiante);
		$location.path('/lista');
	}
	
}]);
