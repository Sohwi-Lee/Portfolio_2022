package controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReservateDAO;

public class ReservateRemoveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 예약취소확인 */
		/* PrintWriter outpr = response.getWriter();
		outpr.println("<script language='javascript'>");
		outpr.println("confirm('예약을 취소하시겠습니까?'); location.href='reserveChk.jsp';");
		outpr.println("</script>");
		outpr.flush(); */
		
		/* 취소 */
		ReservateDAO rdao = ReservateDAO.getInstance();
		String user = String.valueOf(request.getSession().getAttribute("log"));
		int num = Integer.parseInt(request.getParameter("cancelNum"));
		
		String userName = null;
		int carCode = 0;
		Timestamp startD = null;
		Timestamp endD = null;

		for (int i = 0; i < rdao.getLists().size(); i++) {
			if (num == i) {
				userName = rdao.getLists().get(i).getUserName();
				carCode = rdao.getLists().get(i).getCarCode();
				startD = rdao.getLists().get(i).getReserveStart();
				endD = rdao.getLists().get(i).getReserveEnd();
			}
		}

		String url="";
		if (rdao.delReserve(num, userName, carCode, startD, endD) != -1) {
			url="view/reserveChk.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
