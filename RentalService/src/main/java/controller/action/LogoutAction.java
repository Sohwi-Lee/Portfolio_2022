package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("log");
		String url="";
		
		if(request.getSession().getAttribute("log")==null) {
			url="index.jsp";	
		}
		System.out.println(url);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
