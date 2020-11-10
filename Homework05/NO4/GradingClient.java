package YuchenZhao.NO4;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * A command line client for the date server. Requires the IP address of
 * the server as the sole argument. Exits after printing the response.
 */
public class GradingClient {

	public static HashMap<Integer, String> GradesMap = new HashMap<Integer, String>();
	
    public static void main(String[] args) throws IOException, InterruptedException {
    	Student st = null;
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
        var socket = new Socket(args[0], 58901);
        var outPW = new PrintWriter(socket.getOutputStream(), true);
    	var inBR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	outPW.println(1);
       	outPW.flush();
        for (int i = 0; i < 50; i++) {
        	new Thread(st = new Student()).start();
        	Thread.sleep(100);
        	outPW.println(st.scoreMap.get("Homework"));
           	outPW.flush();
        	outPW.println(st.scoreMap.get("Quiz"));
           	outPW.flush();
        	outPW.println(st.scoreMap.get("Midterm"));
           	outPW.flush();
        	outPW.println(st.scoreMap.get("Final"));
           	outPW.flush();
           	outPW.println(st.ID);
           	outPW.flush();
    		outPW.println(st.FirstName);
    		outPW.flush();
            outPW.println(st.LastName);
            outPW.flush();
            GradesMap.put((i + 1), inBR.readLine());
            st.setGrade(GradesMap.get(i+1));
            System.out.println(GradesMap.get(i+1));
        }
        socket.close();
    }
}

class Student implements Runnable {
	
	private String firstname[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX"};
	private String lastname[] = {"B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX", "A"};
	public String Name, FirstName, LastName = "";
	public int ID, Quiz, Midterm, Homework, Final;
	public static int nextID = 1;
	public String Grade;
	public int[] List = {0, 0, 0, 0};
	public Lock lock = new ReentrantLock();
	public HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
	
	File f = new File("src/Grade.txt");
	FileWriter writer = new FileWriter(f, true);

	public Student() throws IOException, InterruptedException {
		f.createNewFile();
		this.Name = firstname[nextID - 1] + " " + lastname[nextID - 1];
		this.FirstName = firstname[nextID - 1];
		this.LastName = lastname[nextID - 1];
		this.ID = nextID++;
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
		lock.lock();
		try {
			Homework = (int)(Math.random() * 30) + 70;
			List[0] = Homework;
			scoreMap.put("Homework", List[0]);
//			Thread.sleep(1000);
			Quiz = (int)(Math.random() * 30) + 70;
			List[1] = Quiz;
			scoreMap.put("Quiz", List[1]);
//			Thread.sleep(1000);
			Midterm = (int)(Math.random() * 30) + 70;
			List[2] = Midterm;
			scoreMap.put("Midterm", List[2]);
//			Thread.sleep(1000);
			Final = (int)(Math.random() * 30) + 70;
			List[3] = Final;
			scoreMap.put("Final", List[3]);
			Thread.sleep(1000);
		}finally {
			lock.unlock();
		}
		
	}

	@Override
	public void run() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + " completed!");
		}  finally {
			lock.unlock();
		}
	}

}
