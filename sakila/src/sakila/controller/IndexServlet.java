package sakila.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.vo.Staff;

@WebServlet("/auth/IndexServlet")
public class IndexServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//필터
		HttpSession session = request.getSession();	
		if(session.getAttribute("loginStaff")==null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet.jsp");
			return;
		}	
		System.out.println("Debug : loginStaff"+session.getAttribute("loginStaff"));
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
