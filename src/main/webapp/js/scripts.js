
var app = angular.module( 'app', [ 'ui.router' ] );

app.config(function ( $stateProvider ) {
  
  var views = {
    addOrEditView: {
      templateUrl: 'views/add-ref-tmpl.html',
      controller: 'RefAddOrUpdateCtrl'
    },
    listView: {
      templateUrl: '/views/list-refs-tmpl.html',
      controller: 'RefListCtrl'
    }
  };
  
  $stateProvider
    .state( 'index', {
      url: '',
      views: views
    })
    .state( 'edit', {
      url: '/{id}',
      views: views
    });

});

app.controller( 'RefAddOrUpdateCtrl', 
  function ( $scope, $http, $state, $window ) {
  
    var isEdit = angular.isDefined( $state.params.id );
    $scope.isEdit = isEdit;

    if ( isEdit ) {

      $http({
        url: '/api/references/' + $state.params.id,
        method: 'GET'
      })
      .success(function ( ref ) {
        $scope.ref = ref;      
      });

    }


    $scope.saveRef = function ( ref ) {

      if ( isEdit ) {
        delete ref.new;
      }

      $http({
        url: '/api/references',
        method: 'PUT',
        data: ref
      })
      .success(function () {

        if ( isEdit ) {
          
           $state.transitionTo ('index', {}, { location: true });
           $window.alert( "Reference has been added! Thank you!" );
           
        } 
        else {
          
          $state.go( $state.current.name, $state.params, { reload: true } );
          $window.alert( "Reference has been saved! Thank you!" );
        
        }
      
      });
    };

});

app.controller( 'RefListCtrl', function ( $scope, $http ) {
        
  $http({
    url: '/api/references',
    method: 'GET'
  })
  .success(function ( refs ) {
    $scope.refs = refs;
  });

});
