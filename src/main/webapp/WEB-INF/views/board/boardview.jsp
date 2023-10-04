<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>${boardVO.id}</div>
	<div>${boardVO.subject}</div>
	<div>${boardVO.content}</div>
	<div>${boardVO.email} (${boardVO.ipAddr})</div>
	<div>${boardVO.viewCnt}</div>
	<div><a href="/board/file/download">${boardVO.originFileName}</a></div>
	<div>${boardVO.crtDt}</div>
	<div>${boardVO.mdfyDt}</div>
	
	<a href="/board/modify/${boardVO.id}">수정</a>
	<a href="/board/delete/${boardVO.id}">삭제</a>
</body>
</html>