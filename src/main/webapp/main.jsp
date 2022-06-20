<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript">
 	var a = 0;
	$(function(){
		console.log("a: "+a);
		$.ajax({
			url: 'user/before_login.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	});
</script>
</head>
<body>

	<div id="disp">
	
	</div>
	
</body>
</html>