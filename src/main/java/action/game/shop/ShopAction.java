package action.game.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.character.Warrior;

/**
 * Servlet implementation class ShopAction
 */
@WebServlet("/game/shop/shop.do")
public class ShopAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//캐릭터 선택에서 넘어왔으면 받은 캐릭터 정보 토대로 pageScope에 추가
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		if(c_idx==1) {//전사
			//Warrior main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}else if(c_idx==2) {//궁수
			//Archer main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}else if(c_idx==3) {//법사
			//Wizard main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}
		
		Warrior main_ch = new Warrior();
		
		///////////////////////////////////////
		//실험용 속성
		main_ch.setC_idx(1);
		main_ch.setC_name("전사");
		main_ch.setC_hp(100);
		main_ch.setC_ad(10);
		main_ch.setC_ap(0);
		main_ch.setC_armor(10);
		main_ch.setC_critical(5);
		main_ch.setC_avd(5);
		main_ch.setC_p_skill("패시브스킬");
		///////////////////////////////////////
		
		ServletContext application = request.getServletContext();
		application.setAttribute("main_ch", main_ch);
		request.setAttribute("main_ch", main_ch);
		
		//아이템 DB에서 랜덤으로 빼서 주고
		//캐릭터 스킬정보 주기
		
		
		//forward
		String forward_page = "shop.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}

