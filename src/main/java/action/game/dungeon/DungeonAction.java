package action.game.dungeon;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.character.Warrior;
import info.mop.Mop1;

/**
 * Servlet implementation class DungeonAction
 */
@WebServlet("/game/dungeon/dungeon.do")
public class DungeonAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//불러내야할 던전 정보 받아서 해당하는 던전 보내기(정확히는 몹정보)
		
		ServletContext application = request.getServletContext();
		Warrior main_ch = (Warrior) application.getAttribute("main_ch");
		
		Mop1 mop1 = new Mop1();
		///////////////////////////////////////
		//실험용 몹 정보
		mop1.setM_idx(1);
		mop1.setM_name("몬스터1");
		mop1.setM_level("일반");
		mop1.setM_hp(100);
		mop1.setM_ad(20);
		mop1.setM_skill("몹 스킬");
		///////////////////////////////////////
		
		application.setAttribute("mop1", mop1);
		request.setAttribute("mop1", mop1);
		request.setAttribute("main_ch", main_ch);
		
		//forward
		String forward_page = "dungeon_skeleton.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
