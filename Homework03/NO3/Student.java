package YuchenZhao.NO3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Student implements Runnable {
	
	private String name[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX"};
	public String Name = "";
	public int ID, Quiz, Midterm, Homework, Final;
	public static int nextID = 1;
	public String Grade;
	public int[] List = {0, 0, 0, 0};
	
	File f = new File("src/Grade.txt");
	FileWriter writer = new FileWriter(f, true);

	public Student() throws IOException, InterruptedException {
		f.createNewFile();
		this.Name = name[nextID - 1];
		this.ID = nextID;
		nextID++;
		setGrade();
	}
	
	public void setQuiz(int quiz) {
		Quiz = quiz;
	}

	public void setMidterm(int midterm) {
		Midterm = midterm;
	}

	public void setHomework(int homework) {
		Homework = homework;
	}

	public void setFinal(int final1) {
		Final = final1;
	}
	
	public void setGrade(String grade) {
		Grade = grade;
	}
	
	public void setGrade() throws InterruptedException {
		Homework = (int)(Math.random() * 30) + 70;
		List[0] = Homework;
		GradesDriver.Grades.put(ID, List);
		Thread.sleep(1000);
		Quiz = (int)(Math.random() * 30) + 70;
		List[1] = Quiz;
		GradesDriver.Grades.put(ID, List);
		Thread.sleep(1000);
		Midterm = (int)(Math.random() * 30) + 70;
		List[2] = Midterm;
		GradesDriver.Grades.put(ID, List);
		Thread.sleep(1000);
		Final = (int)(Math.random() * 30) + 70;
		List[3] = Final;
		GradesDriver.Grades.put(ID, List);
		Thread.sleep(1000);
	}
	
	public String toString() {
		return "Name: " + Name + " ID: " + ID + " Quiz: " + Quiz + " Midterm: " + Midterm + " Final: " + Final + " Homework: " + Homework;
	}

	@Override
	public void run() {
		try {
			writer.write("Name: " + Name + " ID: " + ID +" Quiz: " + Quiz + " Midterm: " + Midterm + " Homework: " + Homework + " Final: " + Final + "\n");
			System.out.println(Thread.currentThread().getName() + " completed!");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
