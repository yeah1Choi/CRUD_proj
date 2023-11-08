package kr.or.ddit.board.dao;

public class BoardDAOImpl implements IBoardDAO {

	// IBoardDAO 안에 들어있는 메서드를 제정의해서 사용합니다.
	// MybatisUtil 클래스에서 얻어온 instance를 이용해 쿼리를 동작한다.
	// 아래 내용을 참고하여 
//	@Override
//	public List<BoardVO> selectBoardList() {
//		SqlSession session = null;
//		List<BoardVO> boardList = null;
//		
//		try {
//			session = MybatisUtil.getSqlSession();
//			
//			boardList = session.selectList("Board.selectBoardList");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session!=null) session.close();
//		}
//		
//		return boardList;
//	}
	
	
}
