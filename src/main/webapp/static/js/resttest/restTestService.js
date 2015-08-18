/**
 * rest test service
 */
(function() {
	var app = angular.module('restTestApp');

	app.angular.service('RestTestController',['$scope', '$http', function($scope, $http) {
		this.addPost =
			function (community) {
				console.log('Starting restService.addPost.');
				var url = '/restTest/communities/111/posts/abc';
				$http.post(url, community).
					success(function(data, status, headers, config) {
						console.log(data);
						if (data && data.header && data.header.isSuccessful === true) {
						}
					});
		};
	}]);
})();
