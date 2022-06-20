<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function start(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'game/story/story_beginning.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
</script>
</head>
<body>
after login<br>
<button onclick="start()">시작</button>
</body>
</html>