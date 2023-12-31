<!-- Page Directive -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Taglib Directive -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardList</title>
    <style type="text/css">
        a:link, a:hover, a:active, a:visited {
            color: #333;
            text-decoration: none;
        }
        table .table {
            border-collapse: collapse;
            border: 1px solid #DDD;
        }
        table .table > thead > tr {
            background-color: #FFF;
        }
        table .table > thead > th {
            padding: 10px;
            color: #333;
        }
        table.table th, table.table td {
            border-right: 1px solid #F0F0F0;
        }
        table.table th:last-child, table.table td:last-child{
            border-right: none;
        }
        table.table > tbody tr:nth-child(odd) {
            background-color: #FAFAFA;
        }
        table.table > tbody td {
            padding: 10px;
            color: #333;
        }
        div.grid {
            display: grid;
            grid-template-columns: 1fr;
            grid-template-rows: 29px 1fr 28px;
            row-gap: 10px;
        }
        div.grid div.right-align{
            text-align: right;
        }
        td > img {
        	width: 100%;
        }
    </style>
</head>
<body>
	
   	<div class="grid">
        <div class="right-align">
            총 ${boardList.boardCnt }건의 게시글이 검색되었습니다.
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>이메일</th>
                    <th>조회수</th>
                    <th>등록일</th>
                    <th>수정일</th>
                </tr>
            </thead>
            <tbody>
            	<c:choose>
            		<c:when test="${not empty boardList.boardList }">
            			<c:forEach items="${boardList.boardList }" var="board">
		                	<tr>
			                    <td>${board.id }</td>
			                    <td>
			                    	<a href="/board/view?id=${board.id }">
			                    		<c:out value="${board.subject }" />
			                    	</a>
			                    </td>
			                    <td>${board.email }</td>
			                    <td>${board.viewCnt }</td>
			                    <td>${board.crtDt }</td>
			                    <td>${board.mdfyDt }</td>
			                </tr>
						</c:forEach>
            		</c:when>
            		<c:otherwise>
            			<tr>
            				<td colspan="6"><img src="https://i.namu.wiki/i/d-PUBHwYYS3mZQQLrfxgZdrUyJm7sIMT7VbD5sT6UYY9SUxF_uPsvO-P5mecdRdkWc0TWnb7F68LTRgi2mX94Qwo02zp8IJ9aQzXsRmY5KfHDk4PfNczvE5j-3JGJwfm8e1WPDr9F7G6e-Wp7lgwCA.webp" /></td>
            			</tr>
            		</c:otherwise>
            	</c:choose>
            </tbody>
        </table>
        <div class="right-align"><a href="/board/write" >게시글 등록</a></div>
    </div>
	
</body>
</html>