package utils;

public class BoardPage {
	/*
	int totalCount : 총 게시물의 개수
	int pageSize : 한 페이지에 출력할 게시물의 개수 (web.xml에 POSTS_PER_PAGE로 저장됨)
	int blockPage : 한 블럭당 출력할 페이지 번호의 개수 (web.xml에 PAGES_PER_BLOCK로 저장됨)
	int pageNum : 현재 진입한 목록의 페이지 번호(최초 진입시에는 무조건 1페이지)
	String reqUrl : 게시판 목록을 실행한 JSP파일 경로(request.getRequstURI()를 통해 경로를 얻어온다.)
	 */
	public static String pagingStr(int totalCount, int pageSize, int blockPage, int pageNum, String reqUrl) {
		String pagingStr = "";
		
		//전체 페이지 수를 계산한다.
		int totalPages = (int)(Math.ceil(((double) totalCount / pageSize)));
		
		/*
		이전 페이지 블록 바로가기 링크 출력
			현재 1페이지라고 가정하면
				(((1-1) / 5) * 5) + 1 = 1
			현재 5페이지라고 가정하면
				(((5-1) / 5) * 5) + 1 = 1 ->첫번째 블럭
 			현재 6페이지라고 가정하면
				(((6-1) / 5) * 5) + 1 = 6 -> 두번째 블럭
			현재 11페이지라고 가정하면
				(((11-1) / 5) * 5) + 1 = 11 -> 세번째 블럭
		 */
		int pageTemp = (((pageNum -1) / blockPage) * blockPage) +1;
		
		if(pageTemp != 1) {
			pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href='" + reqUrl + "?pageNum=1'><i class='bi bi-skip-backward-fill'></i></a></li>";
			pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href='" + reqUrl + "?pageNum=" + (pageTemp -1) + "'><i class='bi bi-skip-start-fill'></i></a></li>";
		}
		
		/*
		각 페이지 번호로 바로가기 링크 출력
		앞에서 계산한 pageTemp를 blockPage만큼 반복해서 출력한다.
		
		 */
		int blockCount = 1;
		while (blockCount <= blockPage && pageTemp <= totalPages) {
			if(pageTemp == pageNum) {
				//현재 페이지에서는 링크를 걸지 않는다.
				pagingStr += "<li class=\"page-item active\"><a class=\"page-link\" >" + pageTemp + "</a></li>";
			}
			else { 
				//현재 페이지가 아닌 경우에만 링크를 걸어준다.
				pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href='" + reqUrl + "?pageNum=" + pageTemp + "'>" + pageTemp + "</a></li>";
			}
			pageTemp++;
			blockCount++;
		}
		
		//다음 페이지 블록 바로가기 링크 출력
		if(pageTemp <= totalPages) {
			pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href='" + reqUrl + "?pageNum=" + pageTemp + "'><i class='bi bi-skip-end-fill'></i></a></li>";
			pagingStr += "<li class=\"page-item\"><a class=\"page-link\" href='" + reqUrl + "?pageNum=" + totalPages + "'><i class='bi bi-skip-forward-fill'></i></a></li>";
		}
		
		return pagingStr;
	}
	
}
