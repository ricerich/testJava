
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList 
{
	//1.����
	int 	bookid;
	String 	bookname;
	String	publisher;
	int		price;
	
	//2.�迭
	int 	bookidArr[];
	String 	booknameArr[];
	String	publisherArr[];
	int		priceArr[];
	
	//3.��ü ->���� Ŭ������ ��������! -> ����, �ܺ�
//	class Book{ //���� Ŭ������
//		int 	bookid1;
//		String 	bookname1;
//		String	publisher1;
//		int		price1;
//	}
	//������ ������!
	
	//3.��ü
//	Book book1 = new Book();
	Book book;
	
	//4.��ü�迭
//	Book bookArr[] = new Book[10];
	Book bookArr[];
	
	
	Connection con; // 1.�������
	Statement stmt;
	ResultSet rs;
	
	public BookList() // ��������� ���� �ʱ�ȭ �Ѵ�. ������ �������� ����
	{
		//2.�迭 �ʱ�ȭ(0�ʱ�ȭ�� �ƴ�, ����� �ʱ�ȭ(�����ʱ�ȭ)
		bookidArr = new int[10];
		booknameArr = new String[10];
		publisherArr = new String[10];
		priceArr = new int[10];
		
		//3.��ü �ʱ�ȭ(���� �ʱ�ȭ)
		book = new Book();
		
		//4.��ü �迭 �ʱ�ȭ(���� �ʱ�ȭ)
		bookArr = new Book[10];
		
		for(int i=0; i<bookArr.length; ++i)
			bookArr[i] = new Book();
		
		
	}

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
	
	public void getBookList() { // 3.�޼ҵ�
		String query = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \tPRICE");
			
			//2.�迭�� �ε��� ����
			int index=0;
			
			//4.��ü�迭�� �ε��� ����
			int index2=0;
			while (rs.next()) {
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1.����
				bookid 	  = rs.getInt(1);
				bookname  = rs.getString(2);
				publisher = rs.getString(3);
				price 	  = rs.getInt(4);
				
				//1.���� ���
//				printBook();
				
				//2.�迭
				bookidArr[index]    = rs.getInt(1);
				booknameArr[index]  = rs.getString(2);
				publisherArr[index] = rs.getString(3);
				priceArr[index] 	= rs.getInt(4);
				
				index++;
				
				//3.��ü
				book.bookid1   = rs.getInt(1);
				book.bookname1 = rs.getString(2);
				book.publisher1= rs.getString(3);
				book.price1    = rs.getInt(4);
				
//				book.printBook();
				
				//4.��ü �迭
				bookArr[index2].bookid1   = rs.getInt(1);
				bookArr[index2].bookname1 = rs.getString(2);
				bookArr[index2].publisher1= rs.getString(3);
				bookArr[index2].price1	 = rs.getInt(4);
				
//				bookArr[index2].printBook();//�̰� ���� ������ �׳� ��ü���� ����
				index2++;

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//1.���� ��¿�
	void printBook()
	{
		System.out.print("\t" +bookid);
		System.out.print("\t" +bookname);
		System.out.print("\t" +publisher);
		System.out.println("\t\t" +price);
		
	}
	
	//2.�迭 ��¿�
	void printBookArr()
	{
		for(int i=0; i<bookidArr.length; ++i)
		{
			System.out.print("\t" +bookidArr[i]);
			System.out.print("\t" +booknameArr[i]);
			System.out.print("\t" +publisherArr[i]);
			System.out.println("\t\t" +priceArr[i]);
		}
	}
}










