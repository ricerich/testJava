package db.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class QueryBean {

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public QueryBean() {

		conn = null;
		stmt = null;
		rs = null;

	}

	public void getConnection() {

		try {

			conn = DBConnection.getConnection();

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		try {

			stmt = conn.createStatement();

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void closeConnection() 
	{
		if (stmt != null) {

			try {

				stmt.close();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		if (conn != null) {

			try {
				conn.close();

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public ArrayList getUserInfo(String user_id) throws Exception {

		StringBuffer sb = new StringBuffer();

		sb.append("SELECT");
		sb.append("   U_ID, U_NAME, U_PHONE, U_GRADE, WRITE_TIME ");
		sb.append(" FROM ");
		sb.append("   USER_INFO_SAMPLE");
		sb.append(" WHERE ");
		sb.append("   U_ID LIKE '%"+user_id+"%' ");
		sb.append(" ORDER BY");
		sb.append("     WRITE_TIME");

		rs = stmt.executeQuery(sb.toString());

		ArrayList res = new ArrayList();
		while (rs.next()) {

			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
			
		}
		System.out.println(sb.toString());
		return res;
	}

}
