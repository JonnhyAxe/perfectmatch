angular.module('artist', [ 'ngRoute' ]).config(function($routeProvider) {

    $routeProvider.when('/', {
        templateUrl : 'home.html',
        controller : 'home'
    }).otherwise('/');

}).controller('home', function($scope, $http, $window) {
    var headers = {
        "Accept" : "application/json",
    };

   $http.get(testMusicByName, {
        headers : headers
    }).success(function(data) {
        $scope.music = data;
    })
});
