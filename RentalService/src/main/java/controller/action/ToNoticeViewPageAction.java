package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NoticeDAO;

public class ToNoticeViewPageAction implements Action{

	String index="";
	public ToNoticeViewPageAction(String idx) {
		index=idx;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
		String url="view/noticeView.jsp?idx="+index;
		dao.setViewCount(Integer.parseInt(index));
		request.getRequestDispatcher(url).forward(request, response);
	}

}
