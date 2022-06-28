package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JSFunction;

@WebServlet("/plantcare/idCheck.do")
public class idController extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		
		String email = req.getParameter("user_id");
		
		System.out.println(email);
		BoardDTO dto = dao.idValidate(email);
		
		boolean result = true;
		
		if(dto.getEmail()==null){
			result = true;
			
			resp.sendRedirect("id_duplicate_check.jsp?email=" + email);
		}
		else if(dto.getEmail().equals(email)) {
			result = false;
			
			JSFunction.alertBack(resp, "중복되었습니다.");
		}
		dao.close();
		
	}
}
