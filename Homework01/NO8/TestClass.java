package NO8;

public class TestClass {

	public TestClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws InterruptedException{
        Data data = new Data();
        Sender sd = new Sender(data);
        Receiver rc = new Receiver(data);
        
        Thread1 t1 =new Thread1(sd);
        Thread2 t2 =new Thread2(rc);
        
        t1.start();
        t2.start();
    }
}
