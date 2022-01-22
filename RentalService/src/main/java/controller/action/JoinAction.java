package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.UserDAO;
import model.dto.UserDTO;

public class JoinAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id = request.getParameter("id");
		   String pw= request.getParameter("pw");
		   String pwChk= request.getParameter("pwChk");
		   String name= request.getParameter("name");
		   String nick= request.getParameter("nick");
		   String email= request.getParameter("mailAddr")+"@"+request.getParameter("mailAddr");
		   String tel = request.getParameter("phoneNum1")+request.getParameter("phoneNum2")+request.getParameter("phoneNum3");	   
		   
		
		   UserDAO dao = UserDAO.getInstance();
		   UserDTO user = new UserDTO(id,pw,nick,name,tel,email,new Timestamp(Calendar.getInstance().getTimeInMillis()));
		   String url="";
			  
		   if(dao.addUser(user)!=-1){	
			  url="index.jsp";
		   }
		   request.getRequestDispatcher(url).forward(request, response);
		
	}

}
