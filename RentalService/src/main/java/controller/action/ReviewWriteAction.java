package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReviewDAO;
import model.dto.ReviewDTO;

public class ReviewWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewDAO redao = ReviewDAO.getInstance();
		
		String user = String.valueOf(request.getSession().getAttribute("log"));
		String carName = request.getParameter("carChoice");
		String content = request.getParameter("content");
		int score = Integer.parseInt(request.getParameter("score"));
		
		String url="";
		if(redao.addList(new ReviewDTO(user,carName,content,score))!=-1){
			url="view/review.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
