package YuchenZhao.NO2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GradesDriver {

	public static ArrayList<Student> Student = new ArrayList<Student>();
	
	public GradesDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		long startTime = System.currentTimeMillis();
		FileWriter w = new FileWriter("src/Grade.txt");
		w.write("");
		w.close();
		Thread[] t = new Thread[32];
		GraderThread gt = new GraderThread();
		Thread t2 = new Thread(gt);
		t2.start();
		for (int i = 0; i < 32; i++) {
			MyThread mt = new MyThread();
			t[i] = new Thread(mt);
			Student.add(mt.st);
			gt.calculateGrade(i);
			t[i].start();
			t[i].join();
			mt.writer.close();
			Thread.sleep(1000);
		}
		t2.join();
		System.out.println("--End--");
		long endTime=System.currentTimeMillis(); 
		System.out.println("Time： "+(endTime - startTime)+"ms"); 
	}
}
