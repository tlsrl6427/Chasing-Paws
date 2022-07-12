package action.game.character;

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
 * Servlet implementation class CharacterChoiceAction
 */
@WebServlet("/game/character/character_choice.do")
public class CharacterChoiceAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//캐릭터 선택에서 넘어왔으면 받은 캐릭터 정보 토대로 pageScope에 추가
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		CharacterVo ex_c_vo = CharacterDao.getInstance().selectOne(c_idx);
		CharacterVo main_ch = null;
		if(c_idx==1) {//전사
			main_ch = new Warrior();
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
		}else if(c_idx==2) {//궁수
			main_ch = new Archer();
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
		}else{//법사
			main_ch = new Wizard();
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
		}
		
		ServletContext application = request.getServletContext();
		application.setAttribute("main_ch", main_ch);
		request.setAttribute("main_ch", main_ch);
		
		//forward
		String forward_page = "../shop/shop.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}
