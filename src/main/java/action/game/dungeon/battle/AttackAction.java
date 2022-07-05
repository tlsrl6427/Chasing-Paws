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
		Mop1 mop1 = (Mop1) application.getAttribute("mop1");

		String attack_method = request.getParameter("attack_method");
		int skill = Integer.parseInt(attack_method.split("skill")[1]);
		
//		  if(attack_method.equals("auto_attack")) {
//		  
//		  }else if(attack_method.equals("a_skill1")) {
//			  mop1.hp_damaged(main_ch.active_skill1()); 
//		  }
		 

		mop1.setM_hp(mop1.getM_hp() - main_ch.getC_ad());
		main_ch.setC_hp(main_ch.getC_hp() - mop1.getM_ad() + main_ch.getC_armor());

		application.removeAttribute("main_ch");
		application.removeAttribute("mop1");

		application.setAttribute("main_ch", main_ch);
		application.setAttribute("mop1", mop1);

		JSONObject json = new JSONObject();
		json.put("main_ch_hp", main_ch.getC_hp());
		json.put("mop1_hp", mop1.getM_hp());
		json.put("main_ch_damage", main_ch.getC_ad());
		json.put("mop1_damage", main_ch.getC_armor() - mop1.getM_ad());

		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json.toJSONString());
	}

}
