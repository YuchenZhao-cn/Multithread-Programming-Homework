package NO5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MyFile {
	
	private String MyString;
	private char[] MyChar;
	private String s;

	public MyFile() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		try {
			File f = new File("data.txt");
			f.createNewFile();
			FileWriter writer = new FileWriter(f);
			writer.write("a,b,c,d,b,c,a,b,b,c,d,e,d,d,e,e,a,b");
			writer.close();
			
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			while((s = br.readLine())!=null) {
	             System.out.println(s);
	             MyString = s;
	        	}
			br.close();
			
			MyChar = MyString.toCharArray();
			List<String> list = new ArrayList<String>();
	        for(int i=0;i<MyChar.length;i++){
	            list.add(MyChar[i]+"");
	        }
	        
	        for (String c : list) {
	        	System.out.print(c);
	        }
	        System.out.println();
	        
	        for (String c : list) {
	        	System.out.print(c.toUpperCase());
	        }
			System.out.println();
			
			System.out.println("There are " + list.size() + " Strings!");
			
			Map<String,Integer> map = new HashMap<String,Integer>();
	        for(String c : list){
	            if(!map.containsKey(c)){ 
	                map.put(c, 1);
	            }else{
	                map.put(c, map.get(c)+1);
	            }
	        }
	        
	        Map<String, Integer> sortedMap = new TreeMap<String,Integer>(map);
	        System.out.println(sortedMap);
	        
	        Set<Map.Entry<String, Integer>> set = map.entrySet();
	        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
            System.out.print("{");
	        while(iterator.hasNext()){
	            Map.Entry<String, Integer> e = iterator.next();
	            System.out.print(" " + e.getKey()+ "=" + e.getValue() + " ");
	        }
            System.out.print("}");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyFile demo = new MyFile();
		demo.run();
	}

}
