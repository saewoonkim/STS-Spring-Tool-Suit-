<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="loginOutLink" value="${sessionScope.id==null ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${sessionScope.id==null ? 'Login' : 'Logout'}"/>

<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>dongsung</title>
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css'/>">
</head>
<body>
	<div id="menu">
		<ul>
			<li id="logo">dongsung</li>
			<li><a href="<c:url value='/'/>">Home</a></li>
			<li><a href="<c:url value='/board/list'/>">Board</a></li>
			<li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
			<li><a href="<c:url value='register/add'/>">Sign in</a></li>
			<li><a href=""><i class="fas fa-search small"></i></a></li>
		</ul>
	</div>
	<div style="text-align:center">
			<h1>This is BOARD</h1>
			<h1>This is BOARD</h1>
			<h1>This is BOARD</h1>
			<h1>This is BOARD</h1>
			<h1>This is BOARD</h1>
	</div>
</body>
</html>