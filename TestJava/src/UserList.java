import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserList 
{
	Connection con; // 1.멤버변수

	public void getCon()// 3.(일반) 메소드 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##추가
		String pwd = "madang"; // c##추가

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("데이터베이스 연결 준비 .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getUserList() { // 3.메소드
		String query = "SELECT custid, name, address, phone FROM customer";
		try {
			Statement stmt = con.createStatement(); // 2
			ResultSet rs = stmt.executeQuery(query); // 3
			System.out.println("사용자ID \t 고객명 \t\t주소 \t\t\t전화번호");
			while (rs.next()) {
				System.out.print("\t" + rs.getInt(1));
				System.out.print("\t" + rs.getString(2));
				System.out.print("\t\t\t" + rs.getString(3));
				System.out.println("\t\t\t\t" + rs.getString(4));
				
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
