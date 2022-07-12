package action.game.dungeon.battle;

import java.awt.List;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import info.character.Warrior;
import info.mop.Mop1_1;
import vo.AttackVo;
import vo.MopVo;
import vo.SkillVo;

/**
 * Servlet implementation class BeforeLoginAction
 */
@WebServlet("/game/dungeon/battle/attack.do")
public class AttackAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext application = request.getServletContext();
		Warrior main_ch = (Warrior) application.getAttribute("main_ch");
		MopVo mop = (MopVo) application.getAttribute("mop");
		AttackVo attack_mop_vo = new AttackVo();
		AttackVo attack_main_ch_vo = new AttackVo();
		
		int s_idx = Integer.parseInt(request.getParameter("s_idx"));// 스킬이 s_idx로 들어와야함
	
		//몬스터에게 cc, 도트뎀, 디버프 적용하기////////////
		String extra_skill_mop = mop.extra_skill();
		String extra_skill_main_ch = main_ch.extra_skill();
		
		if(!extra_skill_mop.equals("cc")) {
			//캐릭터에게 피해 입히기
			mop.attack_character(main_ch, attack_main_ch_vo);
		}
		
		if(!extra_skill_main_ch.equals("cc")) {
			//몬스터에게 피해 입히기
			main_ch.attack_mop(mop, attack_mop_vo, s_idx);
		}
		

		application.removeAttribute("main_ch");
		application.removeAttribute("mop");

		application.setAttribute("main_ch", main_ch);
		application.setAttribute("mop", mop);

		JSONObject json = new JSONObject();
		System.out.println("-----------AttackMopVo------------");
		System.out.println("damage: " + attack_mop_vo.getDamage());
		System.out.println("self_damage: " + attack_mop_vo.getSelf_damage());
		System.out.println("damage_reduced: " + attack_mop_vo.getDamage_reduced());
		System.out.println("damage_reduced_turn: " + attack_mop_vo.getDamage_reduced_turn());
		System.out.println("ad_increased: " + attack_mop_vo.getAd_increased());
		System.out.println("armor_increased: " + attack_mop_vo.getArmor_increased());
		System.out.println("ad_reduced: " + attack_mop_vo.getAd_reduced());
		System.out.println("armor_reduced: " + attack_mop_vo.getArmor_reduced());
		System.out.println("dot_damage: " + attack_mop_vo.getDot_damage());
		System.out.println("dot_damage_turn: " + attack_mop_vo.getDot_damage_turn());
		System.out.println("cc_turn: " + attack_mop_vo.getCc_turn());
		System.out.println("cc_name: " + attack_mop_vo.getCc_name());
		System.out.println("battle_info: " + attack_mop_vo.getBattle_info());
		
		System.out.println("-----------AttackMainChVo------------");
		System.out.println("damage: " + attack_main_ch_vo.getDamage());
		System.out.println("self_damage: " + attack_main_ch_vo.getSelf_damage());
		System.out.println("damage_reduced: " + attack_main_ch_vo.getDamage_reduced());
		System.out.println("damage_reduced_turn: " + attack_main_ch_vo.getDamage_reduced_turn());
		System.out.println("ad_increased: " + attack_main_ch_vo.getAd_increased());
		System.out.println("armor_increased: " + attack_main_ch_vo.getArmor_increased());
		System.out.println("ad_reduced: " + attack_main_ch_vo.getAd_reduced());
		System.out.println("armor_reduced: " + attack_main_ch_vo.getArmor_reduced());
		System.out.println("dot_damage: " + attack_main_ch_vo.getDot_damage());
		System.out.println("dot_damage_turn: " + attack_main_ch_vo.getDot_damage_turn());
		System.out.println("cc_turn: " + attack_main_ch_vo.getCc_turn());
		System.out.println("cc_name: " + attack_main_ch_vo.getCc_name());
		System.out.println("battle_info: " + attack_main_ch_vo.getBattle_info());
		
		System.out.println("-----------CharacterVo------------");
		System.out.println("hp: " + main_ch.getC_hp());
		System.out.println("name: " + main_ch.getC_name());
		System.out.println("ad: " + main_ch.getC_ad());
		System.out.println("ap: " + main_ch.getC_ap());
		System.out.println("armor: " + main_ch.getC_armor());
		System.out.println("critical: " + main_ch.getC_critical());
		System.out.println("avd: " + main_ch.getC_avd());
		
		System.out.println("-----------MopVo------------");
		System.out.println("name: " + mop.getM_name());
		System.out.println("hp: " + mop.getM_hp());
		System.out.println("ad: " + mop.getM_ad());
		System.out.println("armor: " + mop.getM_armor());
		System.out.println("level: " + mop.getM_level());
		
//		json.put("main_ch", main_ch);
//		json.put("mop1", mop1);
//		json.put("attack_info", attack_mop_vo);
		
		
		//main_ch 정보
		json.put("main_ch_hp", main_ch.getC_hp());
		json.put("main_ch_name", main_ch.getC_name());
		json.put("main_ch_ad", main_ch.getC_ad());
		json.put("main_ch_ap", main_ch.getC_ap());
		json.put("main_ch_armor", main_ch.getC_armor());
		json.put("main_ch_critical", main_ch.getC_critical());
		json.put("main_ch_avd", main_ch.getC_avd());
		
		//mop 정보
		json.put("mop_hp", mop.getM_hp());
		json.put("mop_name", mop.getM_name());
		json.put("mop_ad", mop.getM_ad());
		json.put("mop_armor", mop.getM_armor());
		
		//attack 정보
		json.put("name", attack_mop_vo.getName());
		json.put("damage", attack_mop_vo.getDamage());
		json.put("self_damage", attack_mop_vo.getSelf_damage());
		json.put("damage_reduced", attack_mop_vo.getDamage_reduced());
		json.put("damage_reduced_turn", attack_mop_vo.getDamage_reduced_turn());
		json.put("ad_increased", attack_mop_vo.getAd_increased());
		json.put("armor_increased", attack_mop_vo.getArmor_increased());
		json.put("ad_reduced", attack_mop_vo.getAd_reduced());
		json.put("armor_reduced", attack_mop_vo.getArmor_reduced());
		json.put("dot_damage", attack_mop_vo.getDot_damage());
		json.put("dot_damage_turn", attack_mop_vo.getDot_damage_turn());
		json.put("cc_turn", attack_mop_vo.getCc_turn());
		json.put("cc_name", attack_mop_vo.getCc_name());
		
		json.put("attack_mop_info", attack_mop_vo.getBattle_info());
		json.put("attack_main_ch_info", attack_main_ch_vo.getBattle_info());
		if(!extra_skill_mop.equals(""))
			json.put("extra_skill_mop",extra_skill_mop);
		if(!extra_skill_main_ch.equals(""))
			json.put("extra_skill_main_ch",extra_skill_main_ch);
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toJSONString());
	}

}
