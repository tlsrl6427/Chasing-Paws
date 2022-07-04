<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
//선택한 캐릭터 정보 보내기
	function shop(){
		var c_idx = 1;
		a++;
		console.log("a: "+a);
		$.ajax({
			url: 'game/shop/shop.do',
			data: { 'c_idx': c_idx},
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
</script>
</head>
<body>
캐릭터 선택<br>
<button onclick="shop();">상점</button>
</body>
</html>