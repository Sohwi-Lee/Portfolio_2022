package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EventDAO;

public class EventEditAction implements Action{
	int index=-1;
	public EventEditAction(String idx) {
		index = Integer.parseInt(idx);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDAO dao = EventDAO.getInstance();
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		dao.updateBoard(title, content, index);
		
		String url="view/eventView.jsp?idx="+index;
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
