<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<style>
	#character{
		float: left;
	}

	#mop{
		float: right;
	}
	#btns{
		clear: both;
	}
</style>
<script type="text/javascript">
	function choice(){
		a++;
		console.log("a: "+a);
		$.ajax({
			url: '${ pageContext.request.contextPath }/game/shop/shop.do',
			success: function(res_data){
				$('#disp').html(res_data);
			}
		})
	}
	
	function aa(){
		var auto_attack = 0;
		$.ajax({
			url: 'battle/attack.do',
			data: {'s_idx': auto_attack},
			dataType: 'json',
			success: function(res_data){
				alert(res_data.main_ch_damage+"의 피해를 입혔습니다");
				alert(res_data.mop1_damage+"의 피해를 입었습니다");
				$('#main_ch_hp').html('hp: '+ res_data.main_ch_hp);
				$('#mop1_hp').html('hp: '+ res_data.mop1_hp);
			}
		})
	}
	
	function skill(s_idx){
		$.ajax({
			url: 'battle/attack.do',
			data: {'s_idx': s_idx},
			dataType: 'json',
			success: function(res_data){
				alert("!!!");
				alert(res_data.attack_info.damage+"의 피해를 입혔습니다");
				alert(res_data.attack_info.damage+"의 피해를 입었습니다");
				$('#main_ch_hp').html('hp: '+ res_data.main_ch.c_hp);
				$('#mop1_hp').html('hp: '+ res_data.mop1.m_hp);
				
				//스탯
				$('#main_ch_ad').html('ad: '+ res_data.main_ch.c_ad);
				$('#main_ch_ap').html('ap: '+ res_data.main_ch.c_ap);
				$('#main_ch_armor').html('armor: '+ res_data.main_ch.c_armor+"(피해감소 "+ Math.round(100-5000/(res_data.main_ch.c_armor+50)) +"%)");
				$('#main_ch_critical').html('critical: '+ res_data.main_ch.c_critical);
				$('#main_ch_avd').html('avd: '+ res_data.main_ch.c_avd);
				
				$('#mop1_ad').html('hp: '+ res_data.mop1.m_ad);
				$('#mop1_armor').html('hp: '+ res_data.mop1.m_armor);
				
			}
		});
	}
</script>
</head>
<body>
던전<br><br><br><br>

<div>
	<ul id="character">
		<li>캐릭터 정보</li>
		<li>idx: ${ main_ch.c_idx }</li>
		<li>name: ${ main_ch.c_name }</li>
		<li id="main_ch_hp">hp: ${ main_ch.c_hp }</li>
		<li id="main_ch_ad">ad: ${ main_ch.c_ad }</li>
		<li id="main_ch_ap">ap: ${ main_ch.c_ap }</li>
		<li id="main_ch_armor">armor: ${ main_ch.c_armor }(피해감소 ${ 100-5000/(main_ch.c_armor+50) }%)</li>
		<li id="main_ch_critical">critical: ${ main_ch.c_critical }</li>
		<li id="main_ch_avd">avd: ${ main_ch.c_avd }</li>
		<li>auto_attack: ${ main_ch.c_auto_attack }</li>
		<li>p_skill: ${ main_ch.c_p_skill }</li>
		
		<li><button onclick="skill(${ main_ch.skill_vo[0].s_idx });">a_skill1: ${ main_ch.skill_vo[0].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[1].s_idx });">a_skill2: ${ main_ch.skill_vo[1].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[2].s_idx });">a_skill3: ${ main_ch.skill_vo[2].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[3].s_idx });">a_skill4: ${ main_ch.skill_vo[3].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[4].s_idx });">a_skill5: ${ main_ch.skill_vo[4].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[5].s_idx });">a_skill6: ${ main_ch.skill_vo[5].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[6].s_idx });">a_skill7: ${ main_ch.skill_vo[6].s_name }</button></li>
		<li><button onclick="skill(${ main_ch.skill_vo[7].s_idx });">a_skill8: ${ main_ch.skill_vo[7].s_name }</button></li>
	</ul>
	
	<ul id="mop">
		<li>몹 정보</li>
		<li>idx: ${ mop1.m_idx }</li>
		<li>name: ${ mop1.m_name }</li>
		<li id="mop1_hp">hp: ${ mop1.m_hp }</li>
		<li>ad: ${ mop1.m_ad }</li>
		<li>skill: ${ mop1.m_skill }</li>
		<li>level: ${ mop1.m_level }</li>
	</ul>

</div>
<div id="btns">
	<button onclick="aa();">평타공격</button>
	<button onclick="shop();">상점</button>
</div>

</body>
</html>