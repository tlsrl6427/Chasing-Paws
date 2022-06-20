<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'user/after_login.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
	
	function signup(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'user/signup_form.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
</script>
</head>
<body>
	아이디: <input type="text"><br>
	비밀번호: <input type="password"><br>
	<button onclick="login();">로그인</button>
	<button onclick="signup();">회원가입</button>
</body>
</html>