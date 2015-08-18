<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rest Test</title>
</head>
<body ng-app="restTestApp">
<div class="content" ng-controller="RestTestController">
	<div>
		<p>
			<a href="/restTest/communities">@RequestMapping(value = "/communities", method = RequestMethod.GET)</a><br/>
			<a href="/restTest/communities//posts">@RequestMapping(value = "/communities//posts", method = RequestMethod.GET)</a><br/>
			<a href="/restTest/communities/123/posts/456">@RequestMapping(value = "/communities/{communityId}/posts/{postsId}", method = RequestMethod.GET)</a><br/>
			<a href="/restTest/communities/123/posts?searchType=st&searchKeyword=sk">@RequestMapping(value = "/communities/{communityId}/posts", method = RequestMethod.GET) + searchType=st&searchKeyword=sk</a><br/>
			<a href="/restTest/communities/123/posts/search?searchType=st&searchKeyword=sk">@RequestMapping(value = "/communities/{communityId}/posts/search", method = RequestMethod.GET) + searchType=st&searchKeyword=sk</a><br/>
		</p>
	</div>

	<div>
		<form>
			communityId: <input ng-model="communityId" /> {{communityId}}<br/>
			communityName: <input ng-model="communityName" /> {{communityName}}<br/>
			<button ng-click="onPostFormSubmit()">등록(Angular)</button>
			<button id="newPost">등록(jQuery)</button>
		</form>
	</div>

</div>

<script type="text/javascript" src="/static/js/lib/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="/static/js/lib/angularjs/angular.min.js"></script>
<script type="text/javascript" src="/static/js/resttest/restTestApp.js"></script>
<script type="text/javascript" src="/static/js/resttest/restTestController.js"></script>
<script type="text/javascript" src="/static/js/resttest/restTestService.js"></script>
<script>
$(document).ready(function () {
	$('#newPost').click(function() {
		console.log("$('#newPost').click()");
	});

});
</script>
</body>
</html>
