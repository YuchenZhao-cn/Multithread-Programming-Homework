package YuchenZhao.NO4;

public class MultiThread {

public static void main(String args[]) {
     new MyThread("One");
     new MyThread("Two");
     new MyThread("Three");

     try {
    	 Thread.sleep(10000);
     } catch (InterruptedException e) {
    	 System.out.println("Main thread Interrupted");
     }
     System.out.println("Main thread exiting.");
	}
}
