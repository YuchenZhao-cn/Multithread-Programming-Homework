package YuchenZhao.No5.test;

import java.io.IOException;
import org.junit.Test;

import YuchenZhao.No5.run.ProducerConsumerDemo;

public class ProducerConsumerTest {
	
	@Test
    public void test() throws IOException, InterruptedException{

		Runnable Thread1 = new ProducerConsumerDemo();

        new Thread(Thread1).start();
        
        Thread.sleep(10000);
        System.out.println(" main thread terminate");

    }
}
