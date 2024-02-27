<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.net.URLDecoder" %> 
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" /> 
	<style>
		* {box-sizing:border-box;}
		a {text-decoration: none;}
		form {
			width:400px;
			height:500px;
			display:flex;
			flex-direction:column;
			align-items:center;
			position:absolute;
			top:50%;
			left:50%;
			transform:translate(-50%,-50%);
			border:1px solid rgb(89,117,196);
			border-radius:10px;
		}	
		input[type='text'], input[type='password']{
			width:300px;
			height:40px;
			border:1px solid rgb(89,117,196);
			border-radius:5px;
			padding:0 10px;
			margin-bottom:10px;
		}
		button {
			background-color:rgb(89,117,196);
			color:white;
			width:300px;
			height:50px;
			font-size:17px;
			border:none;
			border-radius:5px;
			margin:20px 0 30px 0;
		}
		#title{
			font-size:50px;
			margin:40px 0 30px 0;
		}
		#msg{
			height:30px;
			text-align:center;
			font-size:16px;
			color:red;
			margin_bottom:20px;
		}
	
	
	</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value='/login/login'/>" method="post" onsubmit="return formCheck(this);">
	<h3 id="title">Login</h3>
	<div id="msg">
		<c:if test="${not empty param.msg}">
		<i class ="fa fa-exclamtion-circle"> ${URLDecoder.decode(param.msg)}</i>
		</c:if>
	</div>
	
	<input type="text" name="id" value="${cookie.id.value}" placeholder="���̵� �Է�" autofocus>
	<input type="password" name="pwd" placeholder="��й�ȣ">
	<button>�α���</button>
	<div>									
		<label><input type="checkbox" name="rememberId" ${empty cookie.id.value ? "":"checked" }> ���̵� ��� </label>
		<a href="">��й�ȣ ã��</a>
		<a href="">ȸ������</a>
	</div>
	<script>
		function formCheck(frm){
			let msg='';
			
			if(frm.id.value.length==0){
				setMessage('id�� �Է����ּ���.', frm.id);
				return false;
			}
			
			if(frm.pwd.value.length==0){
				setMessage('pasword�� �Է����ּ���.', frm.pwd);
				return false;
			}
			
			return true;
		}
		
		function setMessage(msg, element){
			document.getElementById("msg").innerHTML = `${'${msg}'}`;
			
			if(element){
				element.select();
			}
		}
	
	</script>

</form>

</body>
</html>