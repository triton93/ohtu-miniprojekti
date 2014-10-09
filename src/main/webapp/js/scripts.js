
var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider) {

  var commonViews = {
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
    .state('index', {
      url: '?refType',
      views: commonViews
    })
    .state('edit', {
      url: '/{id}?refType',
      views: commonViews
    })
    .state('preview', {
      url: '/preview/{id}',
      views: {
        previewView: {
          templateUrl: '/views/preview-tmpl.html',
          controller: 'PreviewCtrl',
          resolve: {
            reference: function($stateParams, $http) {
              return $http({
                url: '/api/references/' + $stateParams.id,
                method: 'GET'
              }).success(function(resp) {
                return resp;
              });
            },
            bibtex: function($stateParams, $http) {
              return $http({
                url: '/api/bibtex/' + $stateParams.id,
                method: 'GET'
              }).success(function(resp) {
                return resp;
              });
            }
          }
        }
      }
    });

});

app.controller('RefAddOrUpdateCtrl',
  function($scope, $http, $state) {

    var isEdit = angular.isDefined($state.params.id);
    $scope.isEdit = isEdit;

    $scope.refTypes = ['Book', 'Article', 'Proceedings'];


    if (isEdit) {

      $http({
        url: '/api/references/' + $state.params.id,
        method: 'GET'
      })
      .success(function(ref) {
        $scope.ref = ref;
      });

    }

    $scope.saveRef = function(ref) {

      if (isEdit) {
        delete ref.new;
      }

      $http({
        url: '/api/references',
        method: 'PUT',
        data: ref
      })
      .success(function() {

        if (isEdit) {
          $state.transitionTo('index', {refType: ref.type}, {location: true});
        }
        else {
          $state.go($state.current.name, {refType: ref.type}, {reload: true});
        }

      });
    };

});

app.controller('RefListCtrl', function($scope, $http, $state) {

  $scope.refType = $state.params.refType === null ? 1 : $state.params.refType;

  $scope.$watch('refType', function(value) {
    $http({
      url: '/api/references',
      method: 'GET',
      params: {
        type: value
      }
    })
    .success(function(refs) {
      $scope.refs = refs;
    });
  });

  $scope.deleteRef = function(ref) {

    var delVal = confirm("Are you sure?");
    if (delVal === true) {
      $http({
        url: '/api/references/' + ref.id,
        method: 'DELETE'
      })
      .success(function() {
        $state.go($state.current.name, {refType: ref.type}, {reload: true});
      });
    };

  };

});

app.controller('PreviewCtrl', function($scope, bibtex, reference) {
  $scope.ref = reference.data;
  $scope.bibtex = bibtex.data;
});