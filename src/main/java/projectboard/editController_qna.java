package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.JSFunction;

@WebServlet("/plantcare/qnaedit_customer.do")
public class editController_qna extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.qnaView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/plantcare/Customer_qna_edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		String name = req.getParameter("name");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		HttpSession session = req.getSession();
		String pass = (String)session.getAttribute("pass");
		
		BoardDTO dto = new BoardDTO();
		dto.setIdx(idx);
		dto.setName(name);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setPass(pass);
		
		BoardDAO dao  = new BoardDAO();
		int result = dao.updateqna(dto);
		dao.close();
		
		if(result==1) {
			session.removeAttribute("pass");
			resp.sendRedirect("../plantcare/qnaview_customer.do?idx="+idx);
		}
		else {
			JSFunction.alertLocation(resp, "비밀번호 확인이 필요합니다.", "../plantcare/qnaview_customer.do?idx="+idx);
		}
		
	}
}
