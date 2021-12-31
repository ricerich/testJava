
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookList 
{
	//1.변수
	int 	bookid;
	String 	bookname;
	String	publisher;
	int		price;
	
	//2.배열
	int 	bookidArr[];
	String 	booknameArr[];
	String	publisherArr[];
	int		priceArr[];
	
	//3.객체 ->먼저 클래스를 만들어야함! -> 내부, 외부
//	class Book{ //내부 클래스로
//		int 	bookid1;
//		String 	bookname1;
//		String	publisher1;
//		int		price1;
//	}
	//밖으로 뺄꺼임!
	
	//3.객체
//	Book book1 = new Book();
	Book book;
	
	//4.객체배열
//	Book bookArr[] = new Book[10];
	Book bookArr[];
	
	
	Connection con; // 1.멤버변수
	Statement stmt;
	ResultSet rs;
	
	public BookList() // 멤버변수의 값을 초기화 한다. 본연의 생성자의 역할
	{
		//2.배열 초기화(0초기화는 아님, 만드는 초기화(생성초기화)
		bookidArr = new int[10];
		booknameArr = new String[10];
		publisherArr = new String[10];
		priceArr = new int[10];
		
		//3.객체 초기화(생성 초기화)
		book = new Book();
		
		//4.객체 배열 초기화(생성 초기화)
		bookArr = new Book[10];
		
		for(int i=0; i<bookArr.length; ++i)
			bookArr[i] = new Book();
		
		
	}

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
	
	public void getBookList() { // 3.메소드
		String query = "SELECT bookid, bookname, publisher, price FROM book";
		try {
			stmt = con.createStatement(); // 2
			rs = stmt.executeQuery(query); // 3
			System.out.println("BOOK ID \tBOOK NAME \tPUBLISHER \tPRICE");
			
			//2.배열용 인덱스 변수
			int index=0;
			
			//4.객체배열용 인덱스 변수
			int index2=0;
			while (rs.next()) {
//				System.out.print("\t" + rs.getInt(1));
//				System.out.print("\t" + rs.getString(2));
//				System.out.print("\t\t\t" + rs.getString(3));
//				System.out.println("\t\t\t\t" + rs.getInt(4));
				
				//1.변수
				bookid 	  = rs.getInt(1);
				bookname  = rs.getString(2);
				publisher = rs.getString(3);
				price 	  = rs.getInt(4);
				
				//1.변수 출력
//				printBook();
				
				//2.배열
				bookidArr[index]    = rs.getInt(1);
				booknameArr[index]  = rs.getString(2);
				publisherArr[index] = rs.getString(3);
				priceArr[index] 	= rs.getInt(4);
				
				index++;
				
				//3.객체
				book.bookid1   = rs.getInt(1);
				book.bookname1 = rs.getString(2);
				book.publisher1= rs.getString(3);
				book.price1    = rs.getInt(4);
				
//				book.printBook();
				
				//4.객체 배열
				bookArr[index2].bookid1   = rs.getInt(1);
				bookArr[index2].bookname1 = rs.getString(2);
				bookArr[index2].publisher1= rs.getString(3);
				bookArr[index2].price1	 = rs.getInt(4);
				
//				bookArr[index2].printBook();//이거 쓸꺼 같으면 그냥 객체쓰면 되지
				index2++;

			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//1.변수 출력용
	void printBook()
	{
		System.out.print("\t" +bookid);
		System.out.print("\t" +bookname);
		System.out.print("\t" +publisher);
		System.out.println("\t\t" +price);
		
	}
	
	//2.배열 출력용
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










