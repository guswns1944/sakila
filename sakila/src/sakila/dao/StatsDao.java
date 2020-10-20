package sakila.dao;

import java.sql.*;

import sakila.query.StatsQuery;
import sakila.vo.Stats;

public class StatsDao {
	//오늘 날짜를 확인하여 날짜에 맞는 모든쿼리 출력
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		Stats returnStats = null;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_IS_DAY);
		stmt.setString(1, stats.getDay());
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			returnStats.setCnt(rs.getLong("cnt"));
		}
		return returnStats;
	}
	//첫 방문자라면 새로 추가
	public void insertStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1,stats.getDay());
		stmt.executeUpdate();
	}
	//날짜가 같은 날 접속시 카운트 증가
	public void updateStats(Connection conn, Stats stats) throws Exception {
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		stmt.executeUpdate();
	}
	//총 접속자 수 
	public int selectTotalCount(Connection conn, Stats stats) throws Exception {
		int totalStats = 0;
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_IS_TOTALCOUNT);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			totalStats = rs.getInt("sum(cnt)");
		}
		return totalStats;
	}
}
