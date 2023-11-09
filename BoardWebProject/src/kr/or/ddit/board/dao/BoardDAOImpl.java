package kr.or.ddit.board.dao;
// IBoardDAO 안에 들어있는 메서드를 제정의해서 사용합니다.
// MybatisUtil 클래스에서 얻어온 instance를 이용해 쿼리를 동작한다.
// 아래 내용을 참고하여 
//@Override
//public List<BoardVO> selectBoardList() {
//	SqlSession session = null;
//	List<BoardVO> boardList = null;
//	
//	try {
//		session = MybatisUtil.getSqlSession();
//		
//		boardList = session.selectList("Board.selectBoardList");
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		if(session!=null) session.close();
//	}
//	
//	return boardList;
//}


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.Board;

public class BoardDAOImpl implements IBoardDAO {
	
	// singleton
	private static BoardDAOImpl dao;
	private BoardDAOImpl() {}
	public static BoardDAOImpl getInstance() {
		if(dao == null) dao = new BoardDAOImpl();
		return dao;
	}

	@Override
	public List<Board> selectList() {
		SqlSession session = null;
		List<Board> boardlist = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			boardlist = session.selectList("board.selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		return boardlist;
	}

	@Override
	public Board selectOne(int bo_no) {
		SqlSession session = null;
		Board board = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			board = session.selectOne("board.selectOne", bo_no);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return board;
	}

	@Override
	public int addBoard(Board board) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("board.addBoard", board);
			
			if (cnt > 0) {
				System.out.println("데이터가 성공적으로 추가되었습니다.");
				session.commit();
			} else {
				System.out.println("데이터 추가를 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(Board board) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.update("board.updateBoard", board);
			
			if (cnt > 0) {
				System.out.println("데이터가 성공적으로 수정되었습니다.");
				session.commit();
			} else {
				System.out.println("데이터 수정를 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int bo_no) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.delete("board.deleteBoard", bo_no);
			
			if (cnt > 0) {
				System.out.println("데이터가 성공적으로 삭제되었습니다.");
				session.commit();
			} else {
				System.out.println("데이터 삭제를 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

}