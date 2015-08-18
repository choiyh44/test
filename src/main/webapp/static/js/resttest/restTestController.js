/**
 * rest test controller
 */
(function() {
	var app = angular.module('restTestApp');

	app.angular.controller('RestTestController',['$scope', 'restService', function($scope, restService) {
		// 폼필드 초기화
		$scope.communityId = '';
		$scope.communityName = '';

		// 포스트추가 버튼 클릭
		$scope.clickAddPostButton = function() {
			// 파라미터생성
			var newPost = {communityId: $scope.communityId ,communityName: $scope.communityName};

			// DB에 등록
			//restService.addPost(newPost);
		};

	}]);
})();
