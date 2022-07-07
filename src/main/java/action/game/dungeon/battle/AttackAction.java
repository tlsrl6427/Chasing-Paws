package action.game.dungeon.battle;

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
		if(mop1.getCc_turn()!=0) {
			mop1.setCc_turn(mop1.getCc_turn()-1);
		}else {
			//캐릭터에게 피해 입히기
			boolean mop_is_buff = main_ch.skilled_by_mop(mop1);
			if(mop_is_buff==true) {//몬스터 자버프
				
			}
		}
		
		//몬스터에게 피해 입히기
		boolean main_ch_is_buff = mop1.skilled_by_character(s_idx, main_ch);
		if(main_ch_is_buff==true) {//캐릭터 자버프
			main_ch.buff_skill(s_idx);
		}

		application.removeAttribute("main_ch");
		application.removeAttribute("mop1");

		application.setAttribute("main_ch", main_ch);
		application.setAttribute("mop1", mop1);

		JSONObject json = new JSONObject();
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
		
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toJSONString());
	}

}
