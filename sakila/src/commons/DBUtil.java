package commons;
import java.sql.*;
public class DBUtil {
	public Connection getConnection() throws Exception {
		// DB의 연결을 위한 util 각각 선언할 경우 정보가 바뀌면 하나하나 수정을 해줘야 하지만 
		// 호출하여 사용하면 이부분만 수정하여 사용하면 모두 적용이 가능하기 때문에 만듬
		// class.forName 은 db리스너에서 실행되기 때문에 제외.
		final String dbaddr = "jdbc:mariadb://localhost:3307/sakila";
		final String dbid = "root";
		final String dbpw = "java1004";
		Connection conn = DriverManager.getConnection(dbaddr,dbid,dbpw);
		conn.setAutoCommit(false);
		return conn;
	}
}
