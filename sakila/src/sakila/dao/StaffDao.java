package sakila.dao;

import java.sql.*;

import sakila.query.StaffQuery;
import sakila.vo.Staff;
import sakila.vo.StaffInfo;

public class StaffDao {
	// 로그인하기위한 역할
	public Staff selectStaffByKey(Connection conn, Staff staff) throws Exception {
		Staff returnStaff = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELECT_STAFF_BY_KEY);
		stmt.setInt(1, staff.getStaffId());
		stmt.setString(2, staff.getPassword());
		System.out.println(stmt);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new Staff();
			returnStaff.setEmail(rs.getString("email"));
			returnStaff.setStoreId(rs.getInt("store_id"));
			returnStaff.setUsername(rs.getString("username"));
		}
		return returnStaff;
	}
	// 로그인한 관리자의 상세정보를 보여주는 역할
	public StaffInfo selectStaffByInfo(Connection conn, StaffInfo staffInfo) throws Exception {
		StaffInfo returnStaff = null;
		PreparedStatement stmt = conn.prepareStatement(StaffQuery.SELEC_STAFF_BY_INFO);
		stmt.setInt(1, staffInfo.getStaffId());
		System.out.println("staffInfoDao");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStaff = new StaffInfo();
			returnStaff.setUsername(rs.getString("username"));
			returnStaff.setName(rs.getString("name"));
			returnStaff.setAddress(rs.getString("address"));
			returnStaff.setCity(rs.getString("city"));
			returnStaff.setCountry(rs.getString("country"));
			returnStaff.setPicture(rs.getString("picture"));
		}
		return returnStaff;
	}
}
