package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.Board;

@WebServlet("/board/boardSearch.do")
public class BoardSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	
    	String sOption = request.getParameter("mysel"); // option의 value 값
    	String sKeyword = request.getParameter("q");
    	
    	Board board = new Board();
    	board.setSearchKey(sOption);
    	board.setSearchResult(sKeyword);
    	
    	IBoardService service = BoardServiceImpl.getInstance();
    	List<Board> searchList = service.selectSearch(board);
    	
    	request.setAttribute("searchList", searchList);
    	
		request.getRequestDispatcher("/WEB-INF/views/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}