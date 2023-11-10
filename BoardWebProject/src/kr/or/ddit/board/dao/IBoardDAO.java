package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.Board;

public interface IBoardDAO {
	
	public List<Board> selectList();
	
	public Board selectOne(int bo_no);
	
	public int addBoard(Board board);
	
	public int updateBoard(Board board);
	
	public int deleteBoard(int bo_no);
	
	public int updateHit(int bo_no);
}
