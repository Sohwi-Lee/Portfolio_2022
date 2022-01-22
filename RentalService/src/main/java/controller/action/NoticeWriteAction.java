package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NoticeDAO;
import model.dto.NoticeDTO;


public class NoticeWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeDTO list = new NoticeDTO(title,content, new Timestamp(Calendar.getInstance().getTimeInMillis()));
		
		String url="";
		if(dao.addList(list)!=-1){
			url="view/notice.jsp";
		}
			
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
