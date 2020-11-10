package YuchenZhao.No4.test;

import static org.junit.Assert.assertEquals;  
import org.junit.After;  
import org.junit.AfterClass;  
import org.junit.Before;  
import org.junit.BeforeClass;  
import org.junit.Test;  
import YuchenZhao.No4.run.Calculation;  
  
public class TestCase {  
  
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
        System.out.println("before class");  
    }  
    
    @Before  
    public void setUp() throws Exception {  
        System.out.println("before");  
    }  
  
    @Test  
    public void testFindMax(){  
        System.out.println("test case find max");  
        assertEquals(4, Calculation.findMax(new int[]{1,3,4,2}));  
        assertEquals(-2, Calculation.findMax(new int[]{-12,-3,-4,-2}));  
    }
    
    @After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  
  
}  

