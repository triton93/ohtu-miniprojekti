
var app = angular.module( 'app', [ 'ui.router' ] );

app.config(function ( $stateProvider ) {
  
  $stateProvider
    .state( 'add', {
      url: '',
      templateUrl: 'views/add-ref-tmpl.html',
      controller: 'RefCtrl'
    })
    .state( 'list', {
      url: '/list',
      templateUrl: '/views/list-refs-tmpl.html',
      controller: function ( $scope, $http ) {
        
        $http({
          url: '/api/references',
          method: 'GET'
        })
        .success(function ( refs ) {
          $scope.refs = refs;
        });
      
      }
    });

});



app.controller( 'RefCtrl', function ( $scope, $http ) {
  
  $scope.addRef = function ( ref ) {
    $http({
      url: '/api/references',
      method: 'PUT',
      data: ref
    });
  };

});

