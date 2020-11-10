package NO4;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MyThreads mt = new MyThreads();
		Thread WriterThread = new Thread(mt);
		Thread ReaderThread1 = new Thread(mt);
		Thread ReaderThread2 = new Thread(mt);
		Thread ReaderThread3 = new Thread(mt);
		Thread ReaderThread4 = new Thread(mt);
		WriterThread.start();
		ReaderThread1.start();
		ReaderThread2.start();
		ReaderThread3.start();
		ReaderThread4.start();

	}

}
