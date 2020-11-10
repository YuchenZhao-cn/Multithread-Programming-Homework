package YuchenZhao.NO6;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 implements Runnable {

    ReentrantLock lock = new ReentrantLock();

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
		ReentrantLock1 rl1 = new ReentrantLock1();
		new Thread(rl1,"1").start();
	}
}
