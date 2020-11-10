package NO2;

public class Student {
	
	private String name[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
	private String Name;
	private int ID, Midterm, Project, Final;
	private static int nextID = 1;

	public Student() {
		this.Name = name[nextID - 1];
		this.ID = nextID;
		nextID++;
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

	public String calculateGrade() {
		double score = 0.3 * Midterm + 0.3 * Project + 0.4 * Final;
		if (score >= 90) return "A";
		else if (score >= 80) return "B";
		else if (score >= 70) return "C";
		else if (score >= 60) return "D";
		else return "F";
	}
	
	public String toString() {
		return "Name: " + Name + " ID: " + ID + " Midterm: " + Midterm + " Final: " + Final + " Project: " + Project + " Grade: " + calculateGrade();
	}

}
