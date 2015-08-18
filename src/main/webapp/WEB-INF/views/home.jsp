<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="curLocale" value="${pageContext.response.locale}" />
<script>
	console.log('curLocale.language : ${curLocale.language}');
	console.log('curLocale.getDisplayCountry : ${curLocale.getDisplayCountry()}');
	console.log('curLocale.toString : ${curLocale.toString()}');
</script>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
