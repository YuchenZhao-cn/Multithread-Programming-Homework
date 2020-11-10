package YuchenZhao.NO5;

import java.util.ArrayList;


public class TreeNode implements Runnable { 
	TreeNode parent = null;  
	ArrayList children = new ArrayList();
	int flag = 0;
	
	public TreeNode() {
		
	}
	
	public synchronized void addChild(TreeNode child){
		if(!this.children.contains(child)) {
			this.children.add(child);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			child.setParentOnly(this);
		}
	}
	  
	public synchronized void addChildOnly(TreeNode child){
		if(!this.children.contains(child)){
			this.children.add(child);
		}
	}
	  
	public synchronized void setParent(TreeNode parent){
		this.parent = parent;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		parent.addChildOnly(this);
	}
	  
	public synchronized void setParentOnly(TreeNode parent){
		this.parent = parent;
	}

	@Override
	public void run() {
		if (flag == 1) {
			addChild(Test.tn2);
		}
		else setParent(Test.tn1);
	}
	  
	
}
