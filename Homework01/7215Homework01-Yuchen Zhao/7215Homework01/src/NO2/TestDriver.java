package NO2;

public class TestDriver {

	public TestDriver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		for (int i = 0; i < 25; i++) {
			Student st = new Student();
			st.setMidterm((int)(Math.random() * 50) + 50);
			st.setProject((int)(Math.random() * 50) + 50);
			st.setFinal((int)(Math.random() * 50) + 50);
			System.out.println(st.toString());
		}
	}

}
