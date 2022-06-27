package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fileupload.FileUtil;
import utils.JSFunction;

@WebServlet("/plantcare/pass.do")
public class passController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("mode", req.getParameter("mode"));
		req.getRequestDispatcher("/plantcare/Customer_qna_pass.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//검증페이지에서 전송한 폼값 받음
		String idx = req.getParameter("idx");
		String mode = req.getParameter("mode");
		String pass = req.getParameter("pass");
		
		//커넥션풀을 통한 DB연결 및 패스워드 검증
		BoardDAO dao = new BoardDAO();
		boolean confirmed = dao.confirmPassword(pass,idx);
		dao.close();
		
		if(confirmed) {
			
			if(mode.equals("edit")) {
				
				HttpSession session = req.getSession();
				session.setAttribute("pass", pass);
				resp.sendRedirect("../plantcare/qnaedit_customer.do?idx="+idx);
			}
			else if(mode.equals("delete")) {
				//삭제인 경우 커넥션 풀을 통해 DB연결
				dao = new BoardDAO();
				//기존의 게시물을 얻어온다.(첨부파일 삭제를 위해 얻어옴)
				BoardDTO dto = dao.qnaView(idx);
				//게시물을 삭제한다.
				int result = dao.deleteqna(idx);
				//커넥션풀에 자원반납
				dao.close();
				
				//알림창을 띄운 후 리스트(목록)으로 이동한다.
				JSFunction.alertLocation(resp, "삭제되었습니다", "../plantcare/qnalist_customer.do");
			}
		}
		else {
			//검증에 실패한 경우 패스워드 입력페이지로 이동한다.
			JSFunction.alertBack(resp, "비밀번호 검증에 실패했습니다.");
		}
	}
	
}
