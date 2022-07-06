package action.game.shop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharacterDao;
import info.character.Archer;
import info.character.Warrior;
import info.character.Wizard;
import vo.CharacterVo;

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
		
		CharacterVo main_ch = null;
		
		if(c_idx==1) {//전사
			main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}else if(c_idx==2) {//궁수
			main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}else if(c_idx==3) {//법사
			main_ch = CharacterDao.getInstance().selectOne(c_idx);
		}
		
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

