package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;

public class myPageEditAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		UserDAO udao = UserDAO.getInstance();
		int idx = -1;
		for (int i = 0; i < udao.getUsers().size(); i++) {
			if (request.getSession().getAttribute("log").equals(udao.getUsers().get(i).getId())) {
				idx = i;
			}
		}
		
		String nick = request.getParameter("nick");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String id = udao.getUsers().get(idx).getId();
		
		String url="";
		//if( udao.updateUser(idx, nick, tel, email, id) !=-1 ){
		//}
			udao.updateUser(idx, nick, tel, email, id);
			url="/myPage/myPage.jsp";
		System.out.println(udao.updateUser(idx, nick, tel, email, id));
		System.out.println("+ "+nick+tel+email+id);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
