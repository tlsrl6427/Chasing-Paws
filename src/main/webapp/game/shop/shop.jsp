<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap');
</style>
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" type="text/css" href="../css/logo.css">
<script type="text/javascript">
//던전 정보 보내기
//스테이지 넘어갈때마다 dungeon변수에 +해줘서 불러내야할 던전정보 특정하기
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

<div id="box">
<!------------------------------------------------------------------------>
	<div id="header">
		<a href="../index.jsp">
			<img id="logo" src="../img/logo.png">
		</a>						
	</div>
<!------------------------------------------------------------------------>
	<div id="content">
		
	</div>	
<!------------------------------------------------------------------------>
	<div id = "footer">
		<p id="copyright">Copyright 2022.Chasing Paws All rights reserved.</p>
	</div>
<!------------------------------------------------------------------------>	
</div>	
<button onclick="dungeon();">던전 입장</button>
</body>
</html>