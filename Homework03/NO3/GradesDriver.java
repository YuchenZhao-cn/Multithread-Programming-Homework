package YuchenZhao.NO3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
		Thread[] t = new Thread[50];
		GraderThread gt = new GraderThread();
		Thread t2 = new Thread(gt);
		t2.start();
		for (int i = 0; i < 50; i++) {
			Student st = new Student();
			t[i] = new Thread(st);
			Student.add(st);
			t[i].start();
			t[i].join();
			st.writer.close();
		}
		t2.join();
		System.out.println("--End--");
	}
}
