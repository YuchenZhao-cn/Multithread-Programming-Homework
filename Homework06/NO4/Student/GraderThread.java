package YuchenZhao.NO4.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraderThread implements Runnable {

	public GraderThread() {
		// TODO Auto-generated constructor stub
	}
	
	public void calculateGrade(int number) {
		double score = 0.3 * GradesDriver.Student.get(number).Midterm + 0.3 * GradesDriver.Student.get(number).Project + 0.4 * GradesDriver.Student.get(number).Final;
		if (score >= 90) GradesDriver.Student.get(number).setGrade("A");
		else if (score >= 80) GradesDriver.Student.get(number).setGrade("B");
		else if (score >= 70) GradesDriver.Student.get(number).setGrade("C");
		else if (score >= 60) GradesDriver.Student.get(number).setGrade("D");
		else GradesDriver.Student.get(number).setGrade("F");
	}

	@Override
	public void run() {
		String s;
		try {
			for (int i = 0; i < 7; i++) {
				BufferedReader br = new BufferedReader(new FileReader("src/Grade.txt"));
				while((s = br.readLine())!=null) {
			        System.out.println(s);
			   	}
				br.close();
				if (i != 6) Thread.sleep(5000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
