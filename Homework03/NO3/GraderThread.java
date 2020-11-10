package YuchenZhao.NO3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GraderThread implements Runnable {
	
	File f0 = new File("src/FinalGrades.txt");
	FileWriter writer0 = new FileWriter(f0);

	public GraderThread() throws IOException {
		writer0.write("");
		writer0.close();
	}
	
	public void calculateGrade(int number) {		
		double grade = 0.3 * GradesDriver.Grades.get(number)[0] + 0.3 * GradesDriver.Grades.get(number)[1] + 0.2 * GradesDriver.Grades.get(number)[2] + 0.2 * GradesDriver.Grades.get(number)[3];
		if (grade >= 90) {GradesDriver.Student.get(number - 1).setGrade("A"); GradesDriver.FinalGrade.put(GradesDriver.Student.get(number - 1).Name, "A");}
		else if (grade >= 80) {GradesDriver.Student.get(number - 1).setGrade("B"); GradesDriver.FinalGrade.put(GradesDriver.Student.get(number - 1).Name, "B");}
		else if (grade >= 70) {GradesDriver.Student.get(number - 1).setGrade("C"); GradesDriver.FinalGrade.put(GradesDriver.Student.get(number - 1).Name, "C");}
		else if (grade >= 60) {GradesDriver.Student.get(number - 1).setGrade("D"); GradesDriver.FinalGrade.put(GradesDriver.Student.get(number - 1).Name, "D");}
		else {GradesDriver.Student.get(number - 1).setGrade("F"); GradesDriver.FinalGrade.put(GradesDriver.Student.get(number - 1).Name, "F");}
	}

	@Override
	public void run() {
		String s,t;
		int student;
		try {
			Thread.sleep(200);
			for (int i = 0; i < 11; i++) {
				if (GradesDriver.Student.size() > 4) {
					for (int j = 0; j < 5; j++) {
						calculateGrade(GradesDriver.Student.size() - 4 + j);
						student = GradesDriver.Student.size() - 5 + j;
						FileWriter writer = new FileWriter(f0, true);
						writer.write("Name: " + GradesDriver.Student.get(student).Name + " Final Grade: " + GradesDriver.FinalGrade.get(GradesDriver.Student.get(student).Name) + "\n");
						writer.close();
					}
				}
				BufferedReader br = new BufferedReader(new FileReader("src/Grade.txt"));
				BufferedReader br0 = new BufferedReader(new FileReader("src/FinalGrades.txt"));
				while((s = br.readLine()) != null && (t = br0.readLine()) != null) {
			        System.out.println(s + " (" + t + ")");
			   	}
				br.close();
				br0.close();
				if (i != 10)Thread.sleep(20500);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
