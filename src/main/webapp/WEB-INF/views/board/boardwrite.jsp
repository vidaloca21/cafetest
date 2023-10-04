<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.errors {
		background-color: #ff00004a;
		opacity: 0.8;
		padding: 10px;
		color: #333;
	}
	
	div.errors:last-child {
		margin-bottom: 15px;
	}
</style>
</head>
<body>
	<form:form modelAttribute="boardVO" method="post" enctype='multipart/form-data'>
		<div class="errors">
			<form:errors path="subject" element="div" cssClass="errors" />
			<form:errors path="email" element="div" cssClass="errors" />
			<form:errors path="content" element="div" cssClass="errors" />
		</div>
		<label for='subject'>제목</label>
		<input id='subject' type='text' name='subject' value='${boardVO.subject}'/>
		<label for='content'>내용</label>
		<textarea id='content' name='content' >${boardVO.content}</textarea>
		<label for='email'>이메일</label>
		<input id='email' type='email' name='email' value='${boardVO.email}'/>
		<label for='file'>첨부파일</label>
		<input id='file' type='file' name='file' />
		<input type='submit' value='저장' />
	</form:form>
</body>
</html>