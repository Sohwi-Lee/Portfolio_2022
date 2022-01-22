package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EventDAO;

public class ToEventViewPageAction implements Action{

	String index="";
	public ToEventViewPageAction(String idx) {
		index=idx;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDAO dao = EventDAO.getInstance();
		String url="view/eventView.jsp?idx="+index;
		dao.setViewCount(Integer.parseInt(index));
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
