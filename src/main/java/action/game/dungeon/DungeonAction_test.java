package action.game.dungeon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharacterDao;
import info.character.Warrior;
import info.mop.Mop1;
import vo.CharacterVo;
import vo.MopVo;

/**
 * Servlet implementation class DungeonAction
 */
@WebServlet("/game/dungeon/dungeon_test.do")
public class DungeonAction_test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//불러내야할 던전 정보 받아서 해당하는 던전 보내기(정확히는 몹정보)
		
		ServletContext application = request.getServletContext();
//		CharacterVo main_ch = (Warrior) application.getAttribute("main_ch");
		
		CharacterVo ex_c_vo = CharacterDao.getInstance().selectOne(1);
		Warrior main_ch = new Warrior();
		main_ch.setC_idx(ex_c_vo.getC_idx());
		main_ch.setC_name(ex_c_vo.getC_name());
		main_ch.setC_hp(ex_c_vo.getC_hp());
		main_ch.setC_ad(ex_c_vo.getC_ad());
		main_ch.setC_ap(ex_c_vo.getC_ap());
		main_ch.setC_armor(ex_c_vo.getC_armor());
		main_ch.setC_critical(ex_c_vo.getC_critical());
		main_ch.setC_avd(ex_c_vo.getC_avd());
		main_ch.setC_auto_attack(ex_c_vo.getC_auto_attack());
		main_ch.setC_p_skill(ex_c_vo.getC_p_skill());
		main_ch.setC_img(ex_c_vo.getC_img());
		main_ch.setSkill_vo(ex_c_vo.getSkill_vo());
		
		System.out.println("c_idx: " + main_ch.getC_idx());
		System.out.println("c_name: " + main_ch.getC_name());
		System.out.println("c_hp: " + main_ch.getC_hp());
		System.out.println("c_ad: " + main_ch.getC_ad());
		System.out.println("c_ap: " + main_ch.getC_ap());
		System.out.println("c_armor: " + main_ch.getC_armor());
		System.out.println("c_critical: " + main_ch.getC_critical());
		System.out.println("c_avd: " + main_ch.getC_avd());
		
		System.out.println("c_auto_attack: " + main_ch.getC_auto_attack());
		System.out.println("c_p_skill: " + main_ch.getC_p_skill());
		System.out.println("c_img: " + main_ch.getC_img());
		
		MopVo mop1 = new MopVo();
		///////////////////////////////////////
		//실험용 몹 정보
		mop1.setM_idx(1);
		mop1.setM_name("몬스터1");
		mop1.setM_level("일반");
		mop1.setM_hp(100);
		mop1.setM_ad(20);
		mop1.setM_armor(10);
		mop1.setM_skill("몹 스킬");
		///////////////////////////////////////
		application.setAttribute("mop1", mop1);
		application.setAttribute("main_ch", main_ch);
		request.setAttribute("mop1", mop1);
		request.setAttribute("main_ch", main_ch);
		
		//forward
		String forward_page = "dungeon_skeleton2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
