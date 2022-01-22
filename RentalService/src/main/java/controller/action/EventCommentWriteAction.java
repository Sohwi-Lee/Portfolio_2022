package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EventCommentDAO;
import model.dto.CommentDTO;

public class EventCommentWriteAction implements Action{

	String index="";
	public EventCommentWriteAction(String idx) {
		index=idx;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventCommentDAO dao = EventCommentDAO.getInstance();

		int idxNum = Integer.parseInt(index);
		String id = String.valueOf(request.getSession().getAttribute("log"));
		Timestamp regDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
		String content = request.getParameter("content");
		
		CommentDTO newComment = new CommentDTO(idxNum,id,regDate,content);
		
		String url="";
		if(dao.addComment(newComment)!=-1) {
			url="view/eventView.jsp?idx="+index;
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
