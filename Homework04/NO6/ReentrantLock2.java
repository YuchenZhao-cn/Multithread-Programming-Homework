package YuchenZhao.NO6;

public class ReentrantLock2 implements Runnable {

    Lock1 lock = new Lock1();

    public void outer() throws InterruptedException {
       lock.lock();
       inner();
       lock.unlock();
    }
     
    public void inner() throws InterruptedException {
    	System.out.println("Tring to lock lock again...");
    	lock.lock();
    	System.out.println("Here I am!");
    	lock.unlock();
    }

	@Override
	public void run() {
		try {
			outer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ReentrantLock2 rl2 = new ReentrantLock2();
		new Thread(rl2,"1").start();
	}
}
