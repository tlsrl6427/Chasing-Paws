<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
상점<br>
선택한 캐릭터 정보<br>
<ul>
	<li>idx: ${ main_ch.c_idx }</li>
	<li>name: ${ main_ch.c_name }</li>
	<li>hp: ${ main_ch.c_hp }</li>
	<li>ad: ${ main_ch.c_ad }</li>
	<li>ap: ${ main_ch.c_ap }</li>
	<li>armor: ${ main_ch.c_armor }</li>
	<li>critical: ${ main_ch.c_critical }</li>
	<li>avd: ${ main_ch.c_avd }</li>
	<li>p_skill: ${ main_ch.c_p_skill }</li>
	<li>a_skill1: ${ main_ch.c_a_skill1 }</li>
	<li>a_skill2: ${ main_ch.c_a_skill2 }</li>
	<li>a_skill3: ${ main_ch.c_a_skill3 }</li>
	<li>a_skill4: ${ main_ch.c_a_skill4 }</li>
	<li>a_skill5: ${ main_ch.c_a_skill5 }</li>
	<li>a_skill6: ${ main_ch.c_a_skill6 }</li>
</ul>
<button onclick="dungeon();">던전 입장</button>
</body>
</html>