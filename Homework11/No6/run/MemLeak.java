package YuchenZhao.No6.run;

import java.util.Map;

public class MemLeak implements Runnable {

    public final String key;

    public MemLeak(String key) {
        this.key =key;
    }

	@Override
	public void run() {
		try {
            Map map = System.getProperties();
            for(int i = 0; i < 100; i++) {
                map.put(new MemLeak("key"), "value");
                System.out.println(i + " added");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
	}
}