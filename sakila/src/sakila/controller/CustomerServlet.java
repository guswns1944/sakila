package sakila.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sakila.service.CustomerService;
import sakila.vo.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private CustomerService customerService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		if(session.getAttribute("loginStaff")==null) {
			response.sendRedirect(request.getContextPath()+"/auth/IndexServlet.jsp");
			return;
		}	
		int currentPage = 1;
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int rowPerPage = 10;
		ArrayList<Customer> list = customerService.getCustomerList(currentPage, rowPerPage);
		customerService = new CustomerService();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/customer.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
