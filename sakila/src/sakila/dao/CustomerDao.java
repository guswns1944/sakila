package sakila.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import sakila.query.CustomerQuery;
import sakila.vo.Customer;

public class CustomerDao {
	//고객 목록을 보여주는 쿼리
	public ArrayList<Customer> selectCustomerList(Connection conn, int currentPage, int rowPerPage) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		PreparedStatement stmt = conn.prepareStatement(CustomerQuery.SELECT_CUSTOMER_LIST);
		stmt.setInt(1, (currentPage-1)*rowPerPage);
		stmt.setInt(2, rowPerPage);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Customer customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setName(rs.getString("name"));
			customer.setPhone(rs.getString("phone"));
			customer.setNotes(rs.getString("notes"));
			customer.setReturnData(rs.getString("return_date"));
			list.add(customer);
			}
		return list;
	}
}
