import java.io.*;

public class Ex3_FileOutputStreamEx {
	public static void main(String[] args) 
	{
		byte b[] = {7,51,3,4,-1,24};
		
		try {
			FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
			
			for(int i=0;  i<b.length; i++)
				fout.write(b[i]); // 배열 b의 수를 바이너리 그대로 기록
			
			fout.close();
		} catch(IOException e) { }
		
		System.out.println("프로젝트 폴더에 test.out을 저장하였습니다.");
	}
}