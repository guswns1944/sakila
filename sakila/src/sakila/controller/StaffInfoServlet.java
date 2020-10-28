package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.vo.Staff;
import sakila.vo.StaffInfo;

@WebServlet("/StaffInfoServlet")
public class StaffInfoServlet extends HttpServlet {
	private StaffService staffService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		if(session.getAttribute("loginStaff")==null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet.jsp");
			return;
		}
		StaffInfo staffInfo = new StaffInfo();
		staffService = new StaffService();
		Staff staff = (Staff)session.getAttribute("loginStaff");
		staffInfo.setStaffId(staff.getStaffId());
		StaffInfo returnStaff = staffService.getStaffInfo(staffInfo);
		if(returnStaff !=null) {
			request.setAttribute("staffInfo", returnStaff);
		}
		request.getRequestDispatcher("/WEB-INF/views/staffInfo.jsp").forward(request, response);
	}

}
