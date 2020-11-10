package YuchenZhao.No6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import YuchenZhao.No6.run.MemLeak;

public class MultiThreadTest {

    
	@Test
	public void shoudNotMemoryLeak() throws InterruptedException
	{
	    System.gc();
	    System.runFinalization();

	    long memoryUsedBefore = Runtime.getRuntime().freeMemory();
	    long memoryUsedAfter = 0;

        Thread t1 = new Thread(new MemLeak("a"));
        t1.start();
        t1.join();

	    memoryUsedAfter = Runtime.getRuntime().freeMemory();
	    
	    System.out.println(memoryUsedAfter);
	    System.out.println(memoryUsedBefore);
	    
	    assertEquals(memoryUsedAfter, memoryUsedBefore);

        System.out.println(" main thread terminate");
	}
}