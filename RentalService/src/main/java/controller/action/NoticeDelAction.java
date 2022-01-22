package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NoticeDAO;

public class NoticeDelAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
		int idx = Integer.parseInt(request.getParameter("idx"));
		int delIdx=-1;
		for(int i=0;i<dao.getLists().size();i++) {
			if(idx==i) {
				delIdx=i;
			}
		}
		int delNum = dao.getLists().get(delIdx).getNo();
		
		String url="";
		if(dao.delLists(delNum) !=-1) {
			url="view/notice.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
