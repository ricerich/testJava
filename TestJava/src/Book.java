
public class Book 
{
	//1.멤버변수
	int 	bookid1;
	String 	bookname1;
	String	publisher1;
	int		price1;
	
	//2.생성자 - 안만들꺼임!
	//3.메소드
	void printBook()
	{
		System.out.print("\t" +bookid1);
		System.out.print("\t" +bookname1);
		System.out.print("\t" +publisher1);
		System.out.println("\t\t" +price1);
	}
	
}
