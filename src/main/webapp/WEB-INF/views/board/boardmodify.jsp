<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method='post' action="/board/modify" enctype="multipart/form-data">
	<label for='subject'>제목</label>
	<input id='subject' type='text' name='subject' value="${boardVO.subject}" />
	<label for='content'>내용</label>
	<textarea id='content' name='content'>${boardVO.content}</textarea>
	<label for='email'>이메일</label>
	<input id='email' type='email' name='email' value="${boardVO.email}" />
	<label for='file'>첨부파일</label>
	<input id='file' type='file' name='file' />
	현재업로드된파일: ${boardVO.originFileName}
	<input type="submit" value="수정" />
</form>


</body>
</html>