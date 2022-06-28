package action.game.dungeon;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DungeonDao;
import vo.DungeonVo;

/**
 * Servlet implementation class DungeonListAction
 */
@WebServlet("/game/dungeon/list.do")
public class DungeonListAction extends HttpServlet {
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
		int d_idx = Integer.parseInt(request.getParameter("d_idx"));

		// category蹂� �긽�뭹由ъ뒪�듃
		List<DungeonVo> list = DungeonDao.getInstance().selectList(d_idx);

		// request binding
		request.setAttribute("list", list);

		// foward
		String forward_page = "dungeon_skeleton.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}