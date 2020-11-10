package YuchenZhao.NO5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GradesDriver {

	public static ArrayList<Student> Student = new ArrayList<Student>();
	public static HashMap<String, String> FinalGrade = new HashMap<>();
	public static HashMap<Integer, int[]> Grades = new HashMap<>();
	
	public int[] list = {0, 0, 0, 0};
	
	public GradesDriver() {
		// TODO Auto-generated constructor stub
	}
	
	public void initializeGrades() {
		for (int i = 1; i < 51; i++) {
			Grades.put(i, list);
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		GradesDriver gd = new GradesDriver();
		gd.initializeGrades();
		FileWriter w = new FileWriter("src/Grade.txt");
		w.write("");
		w.close();
		var pool = Executors.newFixedThreadPool(51);
		GraderThread gt = new GraderThread();
		pool.execute(gt);
		for (int i = 0; i < 50; i++) {
			Student st = new Student();
			Student.add(st);
			pool.execute(st);
		}
		pool.shutdown();
		pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
		System.out.println("--End--");
	}
}
