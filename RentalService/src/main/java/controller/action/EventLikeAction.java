package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.EventDAO;

public class EventLikeAction implements Action{

	String index="";
	public EventLikeAction(String idx) {
		index=idx;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventDAO dao = EventDAO.getInstance();
		int idxNum = Integer.parseInt(index);
		System.out.println("IDXNUM::"+idxNum);
		int num =dao.getLists().get(idxNum).getLike();
		
		dao.setLikeCount(idxNum);
		
		String url="view/eventView.jsp?idx="+idxNum;
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
