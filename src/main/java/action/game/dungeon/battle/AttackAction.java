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
import info.mop.Mop1;
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
		MopVo mop1 = (MopVo) application.getAttribute("mop1");
		
		int s_idx = Integer.parseInt(request.getParameter("s_idx"));// 스킬이 s_idx로 들어와야함
		int origin_mop_hp = mop1.getM_hp();
		int origin_main_ch_hp = main_ch.getC_hp();
	
		//cc걸렸는지 먼저 보기
		/*
		if(mop1.getCc_turn()!=0) {
			mop1.setCc_turn(mop1.getCc_turn()-1);
		}else {
			//캐릭터에게 피해 입히기
			mop1.attack_character(main_ch);
		}
		*/
		
		AttackVo attack_mop_vo = new AttackVo();
		//몬스터에게 피해 입히기
		main_ch.attack_mop(mop1, attack_mop_vo, s_idx);

		application.removeAttribute("main_ch");
		application.removeAttribute("mop1");

		application.setAttribute("main_ch", main_ch);
		application.setAttribute("mop1", mop1);

		JSONObject json = new JSONObject();
		/*
		json.put("main_ch_hp", main_ch.getC_hp());
		json.put("mop1_hp", mop1.getM_hp());
		json.put("main_ch_damage", origin_mop_hp - mop1.getM_hp());
		json.put("mop1_damage", origin_main_ch_hp - main_ch.getC_hp());
		
		json.put("main_ch_ad", main_ch.getC_ad());
		json.put("main_ch_ap", main_ch.getC_ap());
		json.put("main_ch_armor", main_ch.getC_armor());
		json.put("main_ch_critical", main_ch.getC_critical());
		json.put("main_ch_avd", main_ch.getC_avd());
		
		json.put("mop_ad", mop1.getM_ad());
		json.put("mop_armor", mop1.getM_armor());
		*/
		System.out.println("damage: " + attack_mop_vo.getDamage());
		System.out.println("self_damage: " + attack_mop_vo.getSelf_damage());
		System.out.println("damage_reduced: " + attack_mop_vo.getDamage_reduced());
		System.out.println("ad_increased: " + attack_mop_vo.getAd_increased());
		System.out.println("armor_increased: " + attack_mop_vo.getArmor_increased());
		System.out.println("ad_reduced: " + attack_mop_vo.getAd_reduced());
		System.out.println("armor_reduced: " + attack_mop_vo.getArmor_reduced());
		System.out.println("dot_damage: " + attack_mop_vo.getDot_damage());
		System.out.println("dot_damage_turn: " + attack_mop_vo.getDot_damage_turn());
		System.out.println("cc_turn: " + attack_mop_vo.getCc_turn());
		System.out.println("cc_name: " + attack_mop_vo.getCc_name());
		
		json.put("main_ch", main_ch);
		json.put("mop1", mop1);
		json.put("attack_info", attack_mop_vo);
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toJSONString());
	}

}
