<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="/js/lib/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#email").keyup(function() {
			$.get("/member/regist/available", {
				email: $("#email").val()
			}, function(response) {
				var email = response.email;
				var available = response.available;

				if (available) {
					$("#email").addClass("available")
					$("#email").removeClass("unusable")
					$("#btn").removeAttr("disabled")
				}
				else {
					$("#email").addClass("unusable")
					$("#email").removeClass("available")
					$("#btn").attr("disabled", "disabled")
				}
			})
		})
	})
</script>
<style>
	#registCard {
		width: 400px;
	}
    #registForm {
        display: flex;
        flex-direction: columns;
        width: 400px;
        height: auto;
    }
    ul#labels {
    	display: inline;
    }
    ul#inputs {
    	display: inline;
    }
    ul li {
    	display: flex;
    	margin-bottom: 10px;
    }
    #btn {
    	width: 100%;
    	border: 1px solid #EEE;
    	background-color: #1212FF5B;
    	color: #333;
    	font-weight: bold;
    	font-size: 11pt;
    	cursor: pointer;
    }
    div.errors {
    	background-color: #ff00004a;
		opacity: 0.8;
		padding: 10px;
		color: #333;
    }
	.available {
		background-color: #0F03;
	}
	.unusable {
		background-color: #F003;
	}

</style>
</head>
<body>
	<h1>회원가입</h1>
	<div id="registCard">
        <form:form modelAttribute="memberVO" method="post">
            <div class="errors">
        		<form:errors path="email" element="div" cssClass="errors" />
        		<form:errors path="name" element="div" cssClass="errors" />
        		<form:errors path="password" element="div" cssClass="errors" />
        		<form:errors path="confirmPassword" element="div" cssClass="errors" />
        	</div>
			<div id="registForm">
				<ul id="labels">
					<li><label for="email">이메일</label></li>
					<li><label for="name">이름</label></li>
					<li><label for="password">비밀번호</label></li>
					<li><label for="confirmPassword">비밀번호 확인</label></li>
				</ul>
				<ul id="inputs">
        		<li><input id="email" type="email" name="email" value="${memberVO.email}" /></li>
        		<li><input id="name" type="text" name="name" value="${memberVO.name }" /></li>
        		<li><input id="password" type="password" name="password" value="${memberVO.password }" /></li>
        		<li><input id="confirmPassword" type="password" name="confirmPassword" value="${memberVO.confirmPassword }" /></li>
        	</ul>
    	</div>
		<input id="btn" type="submit" value="등록" />
        </form:form>
	</div>

</body>
</html>