package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.JSFunction;

@WebServlet("/plantcare/noticedelete.do")
public class deleteController_notice extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = new BoardDAO();
		dto = dao.noticeView(idx);
		
		HttpSession session = req.getSession();
		String sessionId = session.getAttribute("UserEmail").toString(); 
		System.out.println(sessionId);
		int delResult = 0;

//		//현재 삭제하는 사람이 해당 글의 작성자가 맞는지 확인
//		if(sessionId.equals(dto.getEmail())){ //작성자 본인이 맞으면...
			
			//DTO객체에 일련번호를
			dto.setIdx(idx);
			delResult = dao.noticedelete(dto);
			dao.close();
			
			if (delResult == 1) {
				//게시물 삭제에 성공하면 리스트로 이동한다.
				JSFunction.alertLocation(resp, "삭제되었습니다.", "../plantcare/noticelist_admin.do");
			} 
			else {
				JSFunction.alertBack(resp, "삭제에 실패하였습니다.");
			}
//		}
//		else{
//			//작성자 본인이 아니면 삭제할 수 없음.
//			JSFunction.alertBack( resp, "본인만 삭제할 수 있습니다.");
//			return;
//		}
	}
}
