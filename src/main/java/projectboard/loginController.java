package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/plantcare/login.do")
public class loginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/plantcare/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		BoardDAO dao = new BoardDAO();
		String userEmail = req.getParameter("useremail");
		String userPwd = req.getParameter("userpwd");
		
		BoardDTO boardDTO = dao.memberLogin(userEmail, userPwd);
		dao.close();
		
		HttpSession session = req.getSession();
		if (boardDTO.getEmail() != null) {
			System.out.println("성공");
			//회원인증(로그인)에 성공한 경우
			session.setAttribute("UserEmail", boardDTO.getEmail());
			session.setAttribute("UserName", boardDTO.getName());
			//로그인 페이지로 이동한다.
			resp.sendRedirect("./Plant_main.jsp");
		} else {
			//인증에 실패한 경우
			req.setAttribute("LoginErrMsg", "로그인 오류입니다.");
			//로그인 페이지로 포워드(요청 전달) 한다.
			req.getRequestDispatcher("./plantcare/login.jsp").forward(req, resp);
		}
	}
	
}



