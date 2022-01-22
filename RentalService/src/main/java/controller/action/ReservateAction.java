package controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CarDAO;
import model.dao.ReservateDAO;
import model.dao.UserDAO;
import model.dto.ReservateDTO;

public class ReservateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "";
		if (request.getSession().getAttribute("log") == null) {
			url = "view/login.jsp";
			/*
			 * PrintWriter outpr = response.getWriter();
			 * outpr.println("<script language='javascript'>");
			 * outpr.println("alert('로그인이 필요한 서비스입니다.'); location.href='login.jsp';");
			 * outpr.println("</script>"); outpr.flush();
			 */
		} else {
			CarDAO cdao = CarDAO.getInstance();
			UserDAO udao = UserDAO.getInstance();
			ReservateDAO rdao = ReservateDAO.getInstance();

			String start = request.getParameter("rentS");
			String end = request.getParameter("rentE");

			String carName = request.getParameter("carName");

			if (start == null || end == null) {
				/*
				 * PrintWriter outpr = response.getWriter();
				 * outpr.println("<script language='javascript'>");
				 * outpr.println("alert('날짜를 선택해주세요.'); location.href='reservate.jsp';");
				 * outpr.println("</script>"); outpr.flush();
				 */
			}
			Timestamp startD = Timestamp.valueOf(start);
			Timestamp endD = Timestamp.valueOf(end);
			int totalPrice = Integer.parseInt(request.getParameter("ePrice"));

			/*
			 * System.out.println("car:"+carName); System.out.println("total:"+totalPrice);
			 */

			int index = -1;
			for (int i = 0; i < cdao.getLists().size(); i++) {
				if (cdao.getLists().get(i).getName().equals(carName)) {
					index = i;
					/*
					 * System.out.println("s:" + startD); System.out.println("e:" + endD);
					 * System.out.println("n:" + carName);
					 */
				}
			}
			// 차 데이터테이블의 i번째를 주문

			String userName = String.valueOf(request.getSession().getAttribute("log"));
			int carNo = cdao.getLists().get(index).getNo();

			/*
			 * System.out.println(userName); System.out.println(carNo);
			 * System.out.println(startD); System.out.println(endD);
			 * System.out.println(totalPrice);
			 */

			ReservateDTO reserve = new ReservateDTO(userName, carNo, startD, endD, totalPrice);

			if (rdao.addList(reserve) != -1) {
				url = "view/reserveChk.jsp";
			}
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}
