package projectboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import common.DBConnPool;

public class BoardDAO extends DBConnPool {

	public BoardDAO() {
		super();
	}
	//회원가입
	public int memberregist(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO memberlist VALUES (?,?,?,sysdate)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getPass());
			
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	//로그인
	public BoardDTO memberLogin(String uemail, String upass) {
		BoardDTO dto = new BoardDTO();
		String query = "SELECT * FROM memberlist WHERE email=? AND pass=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uemail);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				dto.setName(rs.getString(1));
				dto.setEmail(rs.getString(2));
				dto.setPass(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	// id중복검사
	public BoardDTO idValidate(String uemail) {
		
		BoardDTO dto = new BoardDTO();
		
		String query = " SELECT email FROM memberlist WHERE email = ? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uemail);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setEmail(rs.getString("email"));
			}
			
		} catch (Exception e) {
			System.out.println("아이디 중복 확인 중 오류 발생");
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "SELECT COUNT(*) FROM memberlist";
//		if (map.get("searchWord") != null) {
//			query += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%'";
//		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	public List<BoardDTO> selectListPage(Map<String, Object> map) {
		List<BoardDTO> board = new ArrayList<BoardDTO>();
//		String query = " SELECT * FROM ( SELECT Tb.*, ROWNUM rNum FROM (SELECT * FROM memberlist ";
//		if (map.get("searchWord") != null) {
//			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
//		}
//		query += " ORDER BY idx DESC ) Tb ) where rNum between ? and ? ";
		
		String query = " SELECT * FROM memberlist ";
		System.out.println(query);
		try {
			psmt = con.prepareStatement(query);
//			psmt.setString(1, map.get("start").toString());
//			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setName(rs.getString(1));
				dto.setEmail(rs.getString(2));
				dto.setPass(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				board.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}
	
	public int ContactWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO contactboard (name, email, phone, subject, ofile, sfile, message, regidate) VALUES (?,?,?,?,?,?,?,sysdate)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getPhone());
			psmt.setString(4, dto.getSubject());
			psmt.setString(5, dto.getOfile());
			psmt.setString(6, dto.getSfile());
			psmt.setString(7, dto.getMessage());
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public int contactCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "SELECT COUNT(*) FROM contactboard";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	public List<BoardDTO> contactListPage(Map<String, Object> map) {
		List<BoardDTO> board = new ArrayList<BoardDTO>();
		
		String query = " SELECT * FROM contactboard ";
		System.out.println(query);
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setName(rs.getString(1));
				dto.setEmail(rs.getString(2));
				dto.setPhone(rs.getString(3));
				dto.setSubject(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setMessage(rs.getString(7));
				dto.setRegidate(rs.getString(8));
				
				board.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}
	public int ApplicationWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = "INSERT INTO applicationboard (address, subaddress, company, name, email, phone, ofile, sfile, message, regidate) VALUES (?,?,?,?,?,?,?,?,?,sysdate)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getAddress());
			psmt.setString(2, dto.getSubaddress());
			psmt.setString(3, dto.getCompany());
			psmt.setString(4, dto.getName());
			psmt.setString(5, dto.getEmail());
			psmt.setString(6, dto.getPhone());
			psmt.setString(7, dto.getOfile());
			psmt.setString(8, dto.getSfile());
			psmt.setString(9, dto.getMessage());
			
			System.out.println(dto.getOfile());
			
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int applicationCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = "SELECT COUNT(*) FROM applicationboard";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<BoardDTO> applicationListPage(Map<String, Object> map) {
		List<BoardDTO> board = new ArrayList<BoardDTO>();
		
		String query = " SELECT * FROM applicationboard ";
		System.out.println(query);
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setAddress(rs.getString(1));
				dto.setSubaddress(rs.getString(2));
				dto.setCompany(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setEmail(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setOfile(rs.getString(7));
				dto.setSfile(rs.getString(8));
				dto.setMessage(rs.getString(9));
				dto.setRegidate(rs.getString(10));
				
				board.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return board;
	}
	
	
	
	public int noticeCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = " SELECT COUNT(*) FROM noticeboard ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " " + " LIKE '%" + map.get("searchWord") + "%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<BoardDTO> noticeListpage_admin(Map<String, Object> map) {
		List<BoardDTO> bbs = new ArrayList<BoardDTO>();

		String query = " SELECT * FROM noticeboard ";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setVisitcount(rs.getInt(8));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	
	public List<BoardDTO> noticeListpage_customer(Map<String, Object> map) {
		List<BoardDTO> bbs = new ArrayList<BoardDTO>();

		String query = " SELECT * FROM ( SELECT Tb.*, ROWNUM rNum FROM (SELECT * FROM noticeboard ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
		}
		query += " ORDER BY idx DESC ) Tb ) where rNum between ? and ? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setVisitcount(rs.getInt(8));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	//글쓰기 처리시 첨부파일까지 함께 입력
	public int noticeWrite(BoardDTO dto) {
		int result = 0;
		try {
			String query = " INSERT INTO noticeboard (idx, name, title, content, ofile, sfile) VALUES (seq_num.NEXTVAL,?,?,?,?,?) ";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	public void updateVisitCount(String num) {
		String query = "UPDATE noticeboard SET visitcount=visitcount+1 WHERE idx=?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			psmt.executeQuery();
		}
		catch(Exception e) {
			System.out.println("게시물 조회수 증가 중 예외 발생");
			e.printStackTrace();
		}
	}
	
	//매개변수로 전달된 일련번호(idx)를 통해 하나의 레코드 조회
	public BoardDTO noticeView(String idx) {
		
		//조회된 레코드를 DTO객체에 저장한 후 반환한다.
		BoardDTO dto = new BoardDTO();
		//인파라미터가 있는 쿼리문 작성
		String query = "SELECT * FROM noticeboard WHERE idx=?";
		try {
			//쿼리실행을 위한 객체 생성 및 인파라미터설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			//조회된 레코드가 있을때 DTO객체에 각 컬럼값을 저장한다.
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setVisitcount(rs.getInt(8));
			}
		}
		catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	//게시물 수정(공지)
	public int noticeEdit(BoardDTO dto) {
		int result = 0;
		try {
			//특정 일련번호에 해당하는 게시물을 수정한다.
			String query = " UPDATE noticeboard SET title=?,content=?, ofile=?, sfile=? WHERE idx=? ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getSfile());
			psmt.setString(5, dto.getIdx());
			
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	//게시물 삭제하기
	public int noticedelete(BoardDTO dto) {
		int result = 0;
		try {
			String query = "DELETE FROM noticeboard WHERE idx=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getIdx());
			
			result = psmt.executeUpdate(); //영향을 받은 행의 개수 반환
		}
		catch(Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	
	/////////////////////////////////////////////////////////////////
	//qna게시판
	public int qnaCount(Map<String, Object> map) {
		int totalCount = 0;

		String query = " SELECT COUNT(*) FROM qnaboard ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		} catch (Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<BoardDTO> qnaListpage_admin(Map<String, Object> map) {
		List<BoardDTO> bbs = new ArrayList<BoardDTO>();

		String query = " SELECT * FROM qnaboard ";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setPass(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	
	public List<BoardDTO> qnaListpage_customer(Map<String, Object> map) {
		List<BoardDTO> bbs = new ArrayList<BoardDTO>();

		String query = " SELECT * FROM ( SELECT Tb.*, ROWNUM rNum FROM (SELECT * FROM qnaboard ";
		if (map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%' ";
		}
		query += " ORDER BY idx DESC ) Tb ) where rNum between ? and ? ";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setPass(rs.getString(5));
				dto.setTitle(rs.getString(6));
				dto.setContent(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
				
				bbs.add(dto);
			}
		} catch (Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	public int qnaWrite_customer(BoardDTO dto) {
		int result = 0;
		try {
			String query = " INSERT INTO qnaboard (idx, name, email, phone, title, content, pass) VALUES (seq_idx.NEXTVAL,?,?,?,?,?,?) ";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getPhone());
			psmt.setString(4, dto.getTitle());
			psmt.setString(5, dto.getContent());
			psmt.setString(6, dto.getPass());
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	public BoardDTO qnaView(String idx) {
		BoardDTO dto = new BoardDTO();
		String query = " SELECT * FROM qnaboard WHERE idx=? ";
		
		try {
			//쿼리실행을 위한 객체 생성 및 인파라미터설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			//조회된 레코드가 있을때 DTO객체에 각 컬럼값을 저장한다.
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setEmail(rs.getString(3));
				dto.setPhone(rs.getString(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setPass(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
			}
		}
		catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean confirmPassword(String pass, String idx) {
		boolean isCorr = true;
		try {
			String sql = "SELECT COUNT(*) FROM qnaboard WHERE pass=? AND idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
			rs = psmt.executeQuery();
			
			rs.next();
			//일치하는 결과가 없는 경우 false를 반환한다.
			if(rs.getInt(1) ==0) {
				isCorr = false;
			}
		}
		catch(Exception e) {
			//예외가 발생하면 검증이 안된것이므로 이때도 false를 반환한다.
			isCorr = false;
			e.printStackTrace();
		}
		//검증이 완료되었을때만 true를 반환한다.
		return isCorr;
	}
	
	//게시물 삭제하기
	public int deleteqna(String idx) {
		int result = 0;
		try {
			String query = "DELETE FROM qnaboard WHERE idx=?";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate(); //영향을 받은 행의 개수 반환
		}
		catch(Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	//게시물 수정처리
	public int updateqna(BoardDTO dto) {
		int result = 0;
		try {
			//업데이트 쿼리문 작성
			String query = "UPDATE qnaboard SET title=?, name=?, email=?, phone=?, content=? WHERE idx=? AND pass=?";
			
			//동적 쿼리문 실행을 위해 prepared객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getEmail());
			psmt.setString(4, dto.getPhone());
			psmt.setString(5, dto.getContent());
			psmt.setString(6, dto.getIdx());
			psmt.setString(7, dto.getPass());
			
			//쿼리 실행 및 결과 반환
			result = psmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	

}
