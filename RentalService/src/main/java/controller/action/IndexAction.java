package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="view/reservation.jsp";			
		System.out.println("URL:"+url);
		// 디스패쳐를 통한 포워드를 하면 url의 변화가 없다.
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
