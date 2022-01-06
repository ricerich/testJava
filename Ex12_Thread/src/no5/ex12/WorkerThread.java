package no5.ex12;

class WorkerThread extends Thread // 스레드 클래스 
{
	private SharedPrinter p; // 공유 프린터 주소
	private String[] text;

	public WorkerThread(SharedPrinter p, String[] text) { // 공유 프린터 주소와 텍스트 전달 받음
		this.p = p;
		this.text = text;
	}

	@Override
	public void run() { // 스레드는 반복적으로 공유 프린터에 10번 접근하여 text[]를 출력한다.
		for (int i = 0; i < text.length; i++) // 한 줄씩 출력
			p.print(text[i]); // 공유 프린터에 출력
	}
}