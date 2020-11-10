package YuchenZhao.NO4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class UpdateClient {
	
	public static int ID;
	public static HashMap<String, Integer> GradesMap = new HashMap<String, Integer>();

	public UpdateClient() {
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
    	Thread t;
        var socket = new Socket(args[0], 58901);
        var outPW = new PrintWriter(socket.getOutputStream(), true);
        t = new Thread(new ClientUpdate());
        t.start();
        t.join();
        outPW.println(2);
       	outPW.flush();
        outPW.println(GradesMap.get("Homework"));
       	outPW.flush();
    	outPW.println(GradesMap.get("Quiz"));
       	outPW.flush();
    	outPW.println(GradesMap.get("Midterm"));
       	outPW.flush();
    	outPW.println(GradesMap.get("Final"));
       	outPW.flush();
       	outPW.println(ID);
       	outPW.flush();
        socket.close();
    }
}

class ClientUpdate implements Runnable {

	@Override
	public void run() {
		String str;
		try {
			System.out.println("Please Enter Students' ID number:");
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			str = buf.readLine();
			UpdateClient.ID = Integer.parseInt(str);
			System.out.println("Please Enter Homework Grade:");
			str = buf.readLine();
			UpdateClient.GradesMap.put("Homework", Integer.parseInt(str));
			System.out.println("Please Enter Quiz Grade:");
			str = buf.readLine();
			UpdateClient.GradesMap.put("Quiz", Integer.parseInt(str));
			System.out.println("Please Enter Midterm Grade:");
			str = buf.readLine();
			UpdateClient.GradesMap.put("Midterm", Integer.parseInt(str));
			System.out.println("Please Enter Final Grade:");
			str = buf.readLine();
			UpdateClient.GradesMap.put("Final", Integer.parseInt(str));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
