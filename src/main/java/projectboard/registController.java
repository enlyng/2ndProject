package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JSFunction;

@WebServlet("/plantcare/regist.do")
public class registController extends HttpServlet {

	//회원가입 페이지 진입
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("./regist.jsp").forward(req, resp);
	}
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//DB연결
		BoardDAO dao = new BoardDAO();
		
		//테이블에 저장하기
		BoardDTO dto = new BoardDTO();
		dto.setName(req.getParameter("name"));
		dto.setEmail(req.getParameter("email"));
		dto.setPass(req.getParameter("pass2"));
		
		
		int result = dao.memberregist(dto);
		dao.close();
		
		if(result ==1) {
//			resp.sendRedirect("/Plant_main.jsp");
			JSFunction.alertLocation(resp, "가입을 축하합니다♥.", "./login.do");
		}
		else {
//			resp.sendRedirect("/plantcare/regist.do");
			JSFunction.alertBack(resp, "실패했습니다.");
		}
		
	}
}
