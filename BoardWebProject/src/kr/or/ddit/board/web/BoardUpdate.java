package kr.or.ddit.board.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.Board;

@WebServlet("/board/boardUpdate.do")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int bo_no = Integer.parseInt(request.getParameter("bo_no"));
    	
    	IBoardService service = BoardServiceImpl.getInstance();
    	
    	Board board = service.selectOne(bo_no);
    	
    	request.setAttribute("board", board);
    	
    	request.getRequestDispatcher("/WEB-INF/views/board/boardUpdate.jsp").forward(request, response);
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		
		String bo_title = request.getParameter("bo_title");
		String bo_writer = request.getParameter("bo_writer");
		String bo_content = request.getParameter("bo_content");
		
		Board board = new Board();
		
		board.setBo_no(bo_no);
		board.setBo_title(bo_title);
		board.setBo_writer(bo_writer);
		board.setBo_content(bo_content);
		
		IBoardService service = BoardServiceImpl.getInstance();
		service.updateBoard(board);
		
		response.sendRedirect(request.getContextPath()+"/board/boardList.do");
	}

}
