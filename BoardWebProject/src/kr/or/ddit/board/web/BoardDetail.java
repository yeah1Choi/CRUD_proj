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

@WebServlet("/board/boardDetail.do")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		Board board = service.selectOne(bo_no);
		
		request.setAttribute("board", board);
		
		request.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
