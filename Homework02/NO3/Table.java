package YuchenZhao.NO3;

public class Table {

	public Table() {
		// TODO Auto-generated constructor stub
	}
	
	 synchronized void printTable(int n){//synchronized method  
		   for(int i=1;i<=5;i++){  
		     System.out.println(n*i);  
		     try{  
		      Thread.sleep(400);  
		     }catch(Exception e){System.out.println(e);}  
		   }  
		 }  


}
