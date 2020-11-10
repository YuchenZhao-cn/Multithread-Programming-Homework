package YuchenZhao.NO3;

public class TestSynchronization2 {

	public TestSynchronization2() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]){  
		Table obj1 = new Table();//only one object  
//		Table obj2 = new Table();//only one object  

		MyThread1 t1=new MyThread1(obj1);  
		MyThread2 t2=new MyThread2(obj1);  
		t1.start();  t2.start();  
		}


}
