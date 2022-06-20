<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function dungeon(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'game/dungeon/dungeon.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
</script>
</head>
<body>
상점<br>
<button onclick="dungeon();">던전 입장</button>
</body>
</html>