package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import commons.DBUtil;
import sakila.dao.StaffDao;
import sakila.vo.Staff;
import sakila.vo.StaffInfo;

public class StaffService {
	private StaffDao staffDao;
	private DBUtil dbUtil;
	// 접속한 스태프의 정보를 보여주는 역할
	public StaffInfo getStaffInfo(StaffInfo staffInfo) {
		dbUtil = new DBUtil();
		staffDao = new StaffDao();
		Connection conn = null;
		StaffInfo returnStaff = null;
		System.out.println("스태프의 정보를 받아오는 값 :"+staffInfo);
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			returnStaff = staffDao.selectStaffByInfo(conn, staffInfo);
			System.out.println("staffInfo 확인");
			System.out.println(returnStaff);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
	}
	// 로그인을 시도한 스태프의 값을 dao로 넘겨주는 역할
	public Staff getStaffByKey(Staff staff) {
		dbUtil = new DBUtil();
		staffDao = new StaffDao();
		Connection conn = null;
		Staff returnStaff = null;
		System.out.println("loginServlet에서 받은 값 :"+staff);
		try {
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			//로그인 정보가 db에 있는지 비교해서 있으면 값을 넣어줌
			returnStaff = staffDao.selectStaffByKey(conn, staff);
			System.out.println("StaffByKey값 들어감"+returnStaff);
			conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return returnStaff;
	}
}
