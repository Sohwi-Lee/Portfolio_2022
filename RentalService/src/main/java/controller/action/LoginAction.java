package controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		 
		UserDAO dao = UserDAO.getInstance();
		String url="";
		System.out.println("LOGINCHK:"+dao.checkLogin(id, pw));
		if(dao.checkLogin(id, pw)){
			//dao.logedin=id;
			request.getSession().setAttribute("log", id);
			url="index.jsp";
		}else{
			/*
			 * response.setContentType("text/html; charset=UTF-8"); PrintWriter outpr =
			 * response.getWriter(); outpr.println("<script language='javascript'>");
			 * outpr.println("alert('아이디 혹은 비밀번호를 확인해주세요');"); outpr.println("</script>");
			 * outpr.flush();
			 */
			 
		    url="view/login.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
