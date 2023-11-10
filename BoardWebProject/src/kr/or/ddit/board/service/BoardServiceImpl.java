package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDAOImpl;
import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.vo.Board;

public class BoardServiceImpl implements IBoardService {
	
	// singleton
	private IBoardDAO dao;
	private static BoardServiceImpl service;
	private BoardServiceImpl() {
		dao = BoardDAOImpl.getInstance();
	}
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public int updateHit(int bo_no) {
		return dao.updateHit(bo_no);
	}

	@Override
	public List<Board> selectList() {
		return dao.selectList();
	}

	@Override
	public Board selectOne(int bo_no) {
		dao.updateHit(bo_no);
		return dao.selectOne(bo_no);
	}

	@Override
	public int addBoard(Board board) {
		return dao.addBoard(board);
	}

	@Override
	public int updateBoard(Board board) {
		return dao.updateBoard(board);
	}

	@Override
	public int deleteBoard(int bo_no) {
		return dao.deleteBoard(bo_no);
	}
}