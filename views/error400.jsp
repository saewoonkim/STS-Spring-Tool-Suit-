<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isErrorPage="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>error400.jsp</title>
</head><body>
<h1>���ܰ� �߻��߽��ϴ�.</h1>
�߻��� ���� : ${pageContext.exception}<br>
���� �޼��� : ${pageContext.exception.message}<br>
<ol>
<c:forEach items="${pageContext.exception.stackTrace}" var="i">
	<li>${i.toString()}</li>
</c:forEach>
</ol>
</body>
</html>