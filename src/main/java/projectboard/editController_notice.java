package projectboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import fileupload.FileUtil;
import utils.JSFunction;


@WebServlet("/plantcare/noticeedit.do")
public class editController_notice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idx = req.getParameter("idx");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.noticeView(idx);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/plantcare/NoticeEdit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String saveDirectory = req.getServletContext().getRealPath("/Uploads");
		ServletContext application = this.getServletContext();
		
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
		//파일업로드 처리. 객체생성과 동시에 업로드는 완료된다.
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		if(mr ==null) {
			JSFunction.alertBack(resp, "첨부 파일이 제한 용량을 초과합니다.");
			return;
		}
		
		//파일을 제외한 나머지 폼값을 얻어온다.
		//hidden 박스에 저장된 내용(게시물 수정 및 파일 수정에 필요함)
		String idx = mr.getParameter("idx");
		String prevOfile = mr.getParameter("prevOfile");
		String prevSfile = mr.getParameter("prevSfile");
		
		//사용자가 직접 입력한 값
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		//DTO에 폼값 저장
		BoardDTO dto = new BoardDTO();
		dto.setIdx(idx);
		dto.setTitle(title);
		dto.setContent(content);
		
		//수정페이지에서 수정(첨부)한 파일이 있는경우 파일명을 변경해준다.
    	String fileName = mr.getFilesystemName("ofile");
    	if(fileName != null) {
    		//날짜와 시간을 이용해서 파일명을 생성한다.
    		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
    		//파일의 확장자를 따낸다
    		String ext = fileName.substring(fileName.lastIndexOf("."));
    		//파일명과 확장자를 합쳐서 새로운 파일명을 만든다.
    		String newFileName = now + ext;
    		//파일 객체 생성 후 파일명을 변경한다.
    		File oldFile = new File(saveDirectory + File.separator + fileName);
    		File newFile = new File(saveDirectory + File.separator + newFileName);
    		oldFile.renameTo(newFile);
    		
    		//업로드된 파일명을 DTO에 저장한다.
    		dto.setOfile(fileName);
    		dto.setSfile(newFileName);
    		
    		//새로운 파일이 등록되었으므로 기존 파일은 삭제한다.
    		FileUtil.deleteFile(req, "/Uploads", prevSfile);
    	}
    	else {
    		//새로운 파일을 등록하지 않는 경우 기존 파일명을 DTO에 저장한다.
    		dto.setOfile(prevOfile);
    		dto.setSfile(prevSfile);
    	}
    	
    	//DB연결 및 업데이트 처리
		BoardDAO dao = new BoardDAO();
		int result =  dao.noticeEdit(dto);
		dao.close();
		
		if(result ==1) {
			resp.sendRedirect("../plantcare/noticeview_admin.do?idx="+idx);
		}
		else {
//			JSFunction.alertLocation(resp, "비밀번호 검증을 다시 진행해주세요.", "../mvcboard/view.do?idx="+idx);
		}
    	
	}
	
}
