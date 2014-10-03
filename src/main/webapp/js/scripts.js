
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
                url: '',
                views: commonViews
            })
            .state('edit', {
                url: '/{id}',
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
                                $state.transitionTo('index', {}, {location: true});
                            }
                            else {
                                $state.go($state.current.name, $state.params, {reload: true});
                            }

                        });
            };

        });

app.controller('RefListCtrl', function($scope, $http, $state) {

    $http({
        url: '/api/references',
        method: 'GET'
    })
            .success(function(refs) {
                $scope.refs = refs;
            });

    $scope.deleteRef = function(ref) {

        var delVal = confirm("Are you sure?");
        if (delVal === true) {
            $http({
                url: '/api/references/' + ref.id,
                method: 'DELETE'
            })
                    .success(function() {
                        $state.go($state.current.name, $state.params, {reload: true});
                    });


        }
        ;
    };

});

app.controller('PreviewCtrl', function($scope, bibtex, reference) {
    $scope.ref = reference.data;
    $scope.bibtex = bibtex.data;
});