package dao;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

// データベース接続
public class Dao {
	static DataSource ds;

	public Connection getConnection() throws Exception {
		if (ds==null) {
			InitialContext ic=new InitialContext();
			ds=(DataSource)ic.lookup("java:/comp/env/jdbc/mateGT");
		}
		return ds.getConnection();
	}
}
