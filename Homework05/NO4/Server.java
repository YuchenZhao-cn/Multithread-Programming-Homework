package YuchenZhao.NO4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Server {

	public static HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
	public static int ID;
	public static String FirstName, LastName;
	public static HashMap<Integer, String> Name = new HashMap<Integer, String>();
	public static HashMap<Integer, String> GradesMap = new HashMap<Integer, String>();
	static File f0 = new File("src/FinalGrades.txt");
	public static int flag = 0;
	
	public Server() throws IOException{
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
        try (var listener = new ServerSocket(58901)) {
            System.out.println("Server is Running...");
            Thread t;
            while(true) {
            	Socket socket = listener.accept();
            	var inBR = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                var outPW = new PrintWriter(socket.getOutputStream(), true);
                flag = Integer.parseInt(inBR.readLine());
                if(flag == 1) {
                	FileWriter writer0 = new FileWriter(f0);
            		writer0.write("");
            		writer0.close();
            		for(int i = 0; i < 50; i++) {
                    	scoreMap.put("Homework", Integer.parseInt(inBR.readLine()));
                    	scoreMap.put("Quiz", Integer.parseInt(inBR.readLine()));
                    	scoreMap.put("Midterm", Integer.parseInt(inBR.readLine()));
                    	scoreMap.put("Final", Integer.parseInt(inBR.readLine()));
                    	ID = Integer.parseInt(inBR.readLine());
                        FirstName = inBR.readLine();
                        LastName = inBR.readLine();
                        t = new Thread(new GraderThread());
                        t.start();
                        t.join();
                        System.out.println(scoreMap.get("Homework") + " " + scoreMap.get("Quiz") + " " + scoreMap.get("Midterm") + " " + scoreMap.get("Final") + " " + ID + " " + FirstName + " " + LastName);
                        System.out.println(GradesMap.get(i + 1));
                        Name.put(ID, FirstName + " " + LastName);
                        outPW.println(GradesMap.get(i + 1));
                        outPW.flush();
                    }
            	}
                else {
                	scoreMap.put("Homework", Integer.parseInt(inBR.readLine()));
                	scoreMap.put("Quiz", Integer.parseInt(inBR.readLine()));
                	scoreMap.put("Midterm", Integer.parseInt(inBR.readLine()));
                	scoreMap.put("Final", Integer.parseInt(inBR.readLine()));
                	ID = Integer.parseInt(inBR.readLine());
                	t = new Thread(new ServerUpdate());
                	t.start();
                	t.join();
                }
            }
        }
    }
}

class GraderThread implements Runnable {

	Lock lock = new ReentrantLock();

	public GraderThread() throws IOException {
	}
	
	public void calculateGrade() {
		lock.lock();
		try {
			double grade = 0.3 * Server.scoreMap.get("Homework") + 0.3 * Server.scoreMap.get("Quiz") + 0.2 * Server.scoreMap.get("Midterm") + 0.2 * Server.scoreMap.get("Final");
			if (grade >= 94) {Server.GradesMap.put(Server.ID, "A");}
			else if (grade >= 88) {Server.GradesMap.put(Server.ID, "B");}
			else if (grade >= 82) {Server.GradesMap.put(Server.ID, "C");}
			else if (grade >= 76) {Server.GradesMap.put(Server.ID, "D");}
			else {Server.GradesMap.put(Server.ID, "F");}
		} finally {
			lock.unlock();
		}
		
	}

	@Override
	public void run() {
		lock.lock();
		try {
			calculateGrade();
			FileWriter writer = new FileWriter(Server.f0, true);
			writer.write("Name: " + Server.FirstName + " " + Server.LastName + " ID: " + Server.ID + " Final Grade: " + Server.GradesMap.get(Server.ID) + "\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class ServerUpdate implements Runnable{
	
	Lock lock = new ReentrantLock();
	
	public ServerUpdate() throws IOException {
		FileWriter writer0 = new FileWriter(Server.f0);
		writer0.write("");
		writer0.close();
	}
	
	public void calculateGrade() {
		lock.lock();
		try {
			double grade = 0.3 * Server.scoreMap.get("Homework") + 0.3 * Server.scoreMap.get("Quiz") + 0.2 * Server.scoreMap.get("Midterm") + 0.2 * Server.scoreMap.get("Final");
			if (grade >= 90) {Server.GradesMap.put(Server.ID, "A");}
			else if (grade >= 80) {Server.GradesMap.put(Server.ID, "B");}
			else if (grade >= 70) {Server.GradesMap.put(Server.ID, "C");}
			else if (grade >= 60) {Server.GradesMap.put(Server.ID, "D");}
			else {Server.GradesMap.put(Server.ID, "F");}
		} finally {
			lock.unlock();
		}
		
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				FileWriter writer;
				writer= new FileWriter(Server.f0, true);
				calculateGrade();
				writer.write("Name: " + Server.Name.get(i + 1) + " ID: " + (i + 1) + " Final Grade: " + Server.GradesMap.get(i + 1) + "\n");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}


