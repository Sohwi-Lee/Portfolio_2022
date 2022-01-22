package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.NoticeDAO;

public class NoticeLikeAction implements Action {
	String index="";
	public NoticeLikeAction(String idx) {
		index=idx;
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeDAO dao = NoticeDAO.getInstance();
		int idxNum = Integer.parseInt(index);
		System.out.println("IDXNUM::"+idxNum);
		int num =dao.getLists().get(idxNum).getLike();
		
		dao.setLikeCount(idxNum);
		
		String url="view/noticeView.jsp?idx="+idxNum;
		request.getRequestDispatcher(url).forward(request, response);

	}

}
