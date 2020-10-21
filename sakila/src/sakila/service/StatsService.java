package sakila.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import commons.DBUtil;
import sakila.dao.StatsDao;
import sakila.vo.Stats;

public class StatsService {
	private DBUtil dbUtil;
	private StatsDao statsDao;
	//
	public Stats getToday() {
		Calendar today = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		String day = formater.format(today.getTime());
		Stats stats = new Stats();
		stats.setDay(day);
		System.out.println("today():"+day);
		return stats;
	}
	// 당일 접속자 수 , 총 방문자 수 호출
	public Map<String, Object> getStats() {
		Stats returnStats = null;
		int totalStats = 0;
		statsDao = new StatsDao();
		
		Connection conn = null;
		Map<String, Object> map = null;
		statsDao = new StatsDao();
		dbUtil = new DBUtil();
		System.out.println("db : "+dbUtil);
		try {	
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			//오늘 날짜 구하는 메소드 호출
			Stats stats = this.getToday();
			returnStats = statsDao.selectDay(conn, stats);
			totalStats = statsDao.selectTotalCount(conn, stats);
			map = new HashMap<String, Object>();
			map.put("returnStats", returnStats);
			map.put("totalStats", totalStats);
			conn.commit();
		} catch(Exception e) {
			System.out.println("getStats(): exception");
			try {
			conn.rollback();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("map :"+map);
		return map;
	}
	// 웹페이지 접근시 리스너를 통해 돌아가는 코드
	public void countStats() {
		
		Connection conn = null;
		statsDao = new StatsDao();
		System.out.println("countStats()");
		dbUtil = new DBUtil();
		try {
			
			conn = dbUtil.getConnection();
			conn.setAutoCommit(false);
			//오늘 날짜 구하는 메소드 호출
			Stats stats = this.getToday();
			if(statsDao.selectDay(conn, stats) == null) {
				statsDao.insertStats(conn, stats);
			}else {
				statsDao.updateStats(conn, stats);
			}
			conn.commit();
		} catch(Exception e) {
			try {
			conn.rollback();
			} catch (SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
