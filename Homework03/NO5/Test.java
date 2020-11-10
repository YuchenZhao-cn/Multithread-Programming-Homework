package YuchenZhao.NO5;

public class Test {
	public static TreeNode tn1 = new TreeNode();
	public static TreeNode tn2 = new TreeNode();
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		tn1.flag = 1;
		tn2.flag = 2;
		new Thread(tn1).start();
		new Thread(tn2).start();
	}
}
