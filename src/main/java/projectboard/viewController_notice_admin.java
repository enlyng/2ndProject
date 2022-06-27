package projectboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plantcare/noticeview_admin.do")
public class viewController_notice_admin extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//커넥트 풀을 통해 DB연결
		BoardDAO dao = new BoardDAO();
		//일련번호를 파라미터로 받음
		String idx = req.getParameter("idx");
		//조회수 증가
		dao.updateVisitCount(idx);
		//게시물 조회
		BoardDTO dto = dao.noticeView(idx);
		System.out.println(idx);
		dao.close();
		
		if(dto.getOfile() != null) {
			String filename = dto.getOfile();
			String ext = filename.substring(filename.lastIndexOf("."));
			String fileType = "";
			if(ext.equals(".png") || ext.equals(".jpg") || ext.equals(".gif")){
				//첨부파일이 이미지인 경우
				fileType = "image";
			}
			else if(ext.equals("mp3")) {
				//음원파일인 경우
				fileType = "audio";
			}
			req.setAttribute("fileType", fileType);
		}
		
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br>"));
		
		//request영역에 DTO를 저장한 후 View로 포워드한다.
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/plantcare/NoticeView.jsp").forward(req, resp);
	}
}
