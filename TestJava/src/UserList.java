import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserList 
{
	Connection con; // 1.�������

	public void getCon()// 3.(�Ϲ�) �޼ҵ� 
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang"; // c##�߰�
		String pwd = "madang"; // c##�߰�

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			System.out.println("�����ͺ��̽� ���� �غ� .....");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getUserList() { // 3.�޼ҵ�
		String query = "SELECT custid, name, address, phone FROM customer";
		try {
			Statement stmt = con.createStatement(); // 2
			ResultSet rs = stmt.executeQuery(query); // 3
			System.out.println("�����ID \t ���� \t\t�ּ� \t\t\t��ȭ��ȣ");
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
