package action.game.character;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharacterDao;
import vo.CharacterVo;

/**
 * Servlet implementation class CharacterListAction
 */
@WebServlet("/game/character/list.do")
public class CharacterListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1. �닔�떊 �씤肄붾뵫
		request.setCharacterEncoding("utf-8");

		// 2. parameter 諛쏄린
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));

		// category蹂� �긽�뭹由ъ뒪�듃
		List<CharacterVo> list = CharacterDao.getInstance().selectList(c_idx);

		// request binding
		request.setAttribute("list", list);

		// foward
		String forward_page = "character_choice.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
