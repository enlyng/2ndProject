package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plantcare/qnawrite_customer.do")
public class writeController_qna extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/plantcare/Customer_qna_write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		
		dto.setName(req.getParameter("name"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setEmail(req.getParameter("email"));
		dto.setPhone(req.getParameter("phone"));
		dto.setPass(req.getParameter("pass"));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.qnaWrite_customer(dto);
		dao.close();
		
		if (result == 1) {
			resp.sendRedirect("../plantcare/qnalist_customer.do");
		} else {
			resp.sendRedirect("../plantcare/qnawrite_customer.do");
		}
	}
}
