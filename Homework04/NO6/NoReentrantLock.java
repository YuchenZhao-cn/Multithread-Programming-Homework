package YuchenZhao.NO6;

public class NoReentrantLock implements Runnable {

    Lock2 lock = new Lock2();

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
		NoReentrantLock nrl = new NoReentrantLock();
		new Thread(nrl,"1").start();
	}
}
