package YuchenZhao.NO2;

public class Student {
	
	private String name[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF"};
	public String Name;
	public int ID, Midterm, Project, Final;
	public static int nextID = 1;
	public String Grade;

	public Student() {
		this.Name = name[nextID - 1];
		this.ID = nextID;
		nextID++;
		setGrade();
	}

	public void setMidterm(int midterm) {
		Midterm = midterm;
	}

	public void setProject(int project) {
		Project = project;
	}

	public void setFinal(int final1) {
		Final = final1;
	}
	
	public void setGrade(String grade) {
		Grade = grade;
	}
	
	public void setGrade() {
		Midterm = (int)(Math.random() * 50) + 50;
		Project = (int)(Math.random() * 50) + 50;
		Final = (int)(Math.random() * 50) + 50;
	}
	
	public String toString() {
		return "Name: " + Name + " ID: " + ID + " Midterm: " + Midterm + " Final: " + Final + " Project: " + Project;
	}

}
