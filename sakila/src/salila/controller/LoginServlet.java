package salila.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.StaffService;
import sakila.service.StatsService;
import sakila.vo.Staff;
import sakila.vo.Stats;

@WebServlet({"/","/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	//로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		if(session.getAttribute("loginStaff")!=null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet.jsp");
			return;
		}
		//오늘 접속자 수 출력을 request로 전달
		statsService = new StatsService();
		Map<String, Object> map = statsService.getStats();
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	//로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		staffService = new StaffService();
		int staffId = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("pw");
		Staff staff = new Staff(); // request로 채움
		staff.setStaffId(staffId);
		staff.setPassword(password);
		Staff returnStaff = staffService.getStaffByKey(staff);
		if(returnStaff != null) {
			HttpSession session = request.getSession();	
			session.setAttribute("loginStaff", returnStaff);
			System.out.println("성공");
			//request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet");
			return;
		}
		System.out.println("실패");
		response.sendRedirect(request.getContextPath()+"/LoginServlet");
	}
}
