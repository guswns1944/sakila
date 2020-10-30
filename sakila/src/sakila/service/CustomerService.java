package sakila.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import commons.DBUtil;
import sakila.dao.CustomerDao;
import sakila.vo.Customer;

public class CustomerService {
	private CustomerDao customerDao;
	private DBUtil dbUtil;
	//고객리스트를 보여주는 역할
	public ArrayList<Customer> getCustomerList(int currentPage, int rowPerPage) {
		ArrayList<Customer> list = new ArrayList<Customer>();
		customerDao = new CustomerDao();
		Connection conn = null;
		System.out.println("고객정보를 받아오는 service:");
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			list = customerDao.selectCustomerList(conn, currentPage, rowPerPage);
			System.out.println("customerList 확인"+list);
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
