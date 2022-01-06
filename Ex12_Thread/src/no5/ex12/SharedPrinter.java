package no5.ex12;
class SharedPrinter // 두 WorkerThread 스레드에 의해 동시 접근되는 공유 프린터 
{
	// synchronized를 생략하면 한글과 영어가 한 줄에 섞여 출력되는 경우가 발생한다. 	
	synchronized void print(String text) 
	{
		// Thread.yield();
		for(int i=0; i<text.length(); i++)
			System.out.print(text.charAt(i));
		System.out.println();
	}
}