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

@WebServlet("/plantcare/qnalist_customer.do")
public class listController_qna_customer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//검색어 관련 파라미터 처리
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWord");
		
		if(searchWord != null) {
			//검색어를 입력한 경우에만 Model(DB)로 전달하기 위해 저장함
			map.put("searchField", searchField);
			map.put("searchWord", searchWord);
		}
		int totalCount = dao.qnaCount(map);
		
		//페이지 처리 start
		//서블릿에서 web.xml에 접근하기 위해 application 내장객체를 얻어옴.
		ServletContext application = getServletContext();
		//컨텍스트 초기화 파라미터를 얻어옴.
		//한 페이지 당 출력할 게시물의 수
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
		//한 블럭당 출력할 페이지 번호 개수
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		int pageNum = 1;
		//파라미터로 넘어오는 pageNum이 있다면 값을 얻어와서
		String pageTemp = req.getParameter("pageNum");
		//정수로 변환한 후 현재 페이지번호로 지정한다.
		if(pageTemp != null && !pageTemp.equals(""))
			pageNum = Integer.parseInt(pageTemp);
		
		//게시물의 구간을 계산함.
		int start = (pageNum -1) * pageSize +1;
		int end = pageNum * pageSize;
		//계산된 값은 Model로 전달하기 위해 Map컬렉션에 저장함.
		map.put("start", start);
		map.put("end", end);
		//페이지 처리 end
		
		//현재 페이지에 출력할 게시물을 얻어옴.
		List<BoardDTO> boardLists = dao.qnaListpage_customer(map);
		//커넥션 풀에 자원 반납
		dao.close();
		
		String pagingImg = BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, "../plantcare/qnalist_customer.do");
		//View로 전달할 데이터를 Map컬렉션에 저장함
		//페이지 번호
		map.put("pagingImg", pagingImg);
		//전체 게시물의 개수
		map.put("totalCount", totalCount);
		//한페이지당 출력할 게시물의 개수(설정값)
		map.put("pageSize", pageSize);
		//현재 페이지 번호
		map.put("pageNum", pageNum);
		//View로 전달할 객체들을 request영역에 저장한다.
		req.setAttribute("boardLists", boardLists);
		req.setAttribute("map", map);
		System.out.println(totalCount);
		req.getRequestDispatcher("./Customer_qna.jsp").forward(req, resp);
		
	}
}
