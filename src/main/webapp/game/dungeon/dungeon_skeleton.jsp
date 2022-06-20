<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function choice(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'game/shop/shop.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
</script>
</head>
<body>
던전<br>
<button onclick="shop();">상점</button>
</body>
</html>