
public class Basic 
{
	public static void main(String args[]) 
	{ // �޼ҵ��̸鼭 ���α׷����࿡ ������
		
//		new Booklist().getBookList();
//		
//		new Booklist().getUserList();
		
//		Booklist bl1 = new Booklist();
//		bl1.getBookList();
//		
//		Booklist bl2 = new Booklist();
//		bl2.getUserList();
//		bl2.getBookList();
		
//		BookList bl3 = new BookList();		
//		bl3.getCon();
//		bl3.getBookList();
//		
//		UserList ul1 = new UserList();		
//		ul1.getCon();
//		ul1.getUserList();
//		ul1.getCon();
//		ul1.getUserList();
		
//		BookList bl4 = new BookList();
//		bl4.getCon();
//		bl4.getBookList();
//		bl4.printBook(); //1.���� ���
//		
//		bl4.getCon();
//		bl4.printBookArr();//2.�迭 ���
//		bl4.printBookArr();//2.�迭 ��� -> �ι�°�� getCon()�ʿ����: ������ �迭�� �� ��������ϱ�~!!!
		
//		BookList bl5 = new BookList();//3.��ü ���
//		bl5.getCon();
//		bl5.getBookList();
//		
//		bl5.getCon();
//		bl5.book.printBook();//���� �������� ��� �ѳ� ��µ�!
		
		BookList bl6 = new BookList();//4.��ü�迭 ���
		bl6.getCon();
		bl6.getBookList();
		
//		bl6.bookArr[0].printBook();
//		bl6.bookArr[1].printBook();
		
		for(int i=0; i<bl6.bookArr.length;++i)
			bl6.bookArr[i].printBook();
				
				
		
		
		
		
		
		
	}
}
