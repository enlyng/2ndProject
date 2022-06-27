package projectboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BoardPage;

@WebServlet("/plantcare/noticelist_admin.do")
public class listController_notice_admin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDAO dao = new BoardDAO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int totalCount = dao.selectCount(map);
		
		
		int pageNum = 1;
		//파라미터로 넘어오는 pageNum이 있다면 값을 얻어와서
		String pageTemp = req.getParameter("pageNum");
		//정수로 변환한 후 현재 페이지번호로 지정한다.
		if(pageTemp != null && !pageTemp.equals(""))
			pageNum = Integer.parseInt(pageTemp);
		
		//현재 페이지에 출력할 게시물을 얻어옴.
		List<BoardDTO> boardLists = dao.noticeListpage_admin(map);
		//커넥션 풀에 자원 반납
		dao.close();
		
		
		//전체 게시물의 개수
		map.put("totalCount", totalCount);
	
		//현재 페이지 번호
		map.put("pageNum", pageNum);
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		System.out.println(totalCount);
		req.getRequestDispatcher("./Notice.jsp").forward(req, resp);
		
		
	}
	
}
