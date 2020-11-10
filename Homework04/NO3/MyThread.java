package YuchenZhao.NO3;

import java.util.Arrays;

public class MyThread implements Runnable {

	int[] arr0;
	int[][] arr;
	int[] arr1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

	public static String SortFlag[] = {"", "", "", ""};
	public static int count = 0;
	
	public MyThread(int row, int[][] arr) {
		this.arr = arr;
	}
	
	public void input(int[][] arr) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				arr1[count] = arr[i][j];
				count++;
			}
		}
	}
	
	public void output(int[][] arr) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				arr[i][j] = arr1[count];
				count++;
			}
		}
	}
	
	public static void HeapSort(int[] a) {
    	BuildHeap(a);
    	swop(a, 0, a.length - 1);
    	for(int j = a.length - 1; j > 0; j--) {
    		AdjustHeap(a, 0, j);
    		swop(a, 0, j - 1);
    	}
    }
	
	public static void AdjustHeap(int[] a, int i, int length) {
		int temp=a[i];
        int k=2 * i + 1;
		for(; k < length; k = 2 * k + 1) {
			if(k + 1 < length && a[k] < a[k + 1]) {
				k = k + 1;
			}
			if(temp < a[k]) {
				a[i] = a[k];
				i = k;
			}else {
				break;
			}	
		}
		a[i] = temp;	
	}
	
    public static void BuildHeap(int[] a) {
		for(int i = a.length / 2 - 1; i >= 0; i--) {
			 AdjustHeap(a, i, a.length);
		}
	}
  
    public static void swop(int a[], int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }

	@Override
	public void run() {
		synchronized(arr) {
			String thread = Thread.currentThread().getName();
			String number = "0";
			switch(thread){
			case "Thread-0":
				arr0 = arr[0]; number = "0"; SortFlag[0] = "(Sorted)";
				break;
			case "Thread-1":
				arr0 = arr[1]; number = "1"; SortFlag[1] = "(Sorted)";
				break;
			case "Thread-2":
				arr0 = arr[2]; number = "2"; SortFlag[2] = "(Sorted)";
				break;
			case "Thread-3":
				arr0 = arr[3]; number = "3"; SortFlag[3] = "(Sorted)";
				break;
			}
			Arrays.sort(arr0);
			System.out.println("\n---------" + Thread.currentThread().getName() + "---------");
			System.out.println("Sort Method(row " + number + "):");
	        for(int i = 0; i < arr0.length; i++) {
	            System.out.print(arr0[i] + " ");
	        }
	        System.out.println();
	        System.out.println();
	        System.out.println("updated array:");
    		for(int i = 0; i < 4; i++) {
    			for (int j = 0; j < 7; j++) {
    				System.out.print(arr[i][j] + " ");
    			}
    			System.out.println(SortFlag[i]);
    		}
	        count++;
	        
	        if(count == 4) {
	        	System.out.println();
	        	System.out.println("---------HeapSort---------");
				input(arr);
		        HeapSort(arr1);
		        output(arr);
		        for(int i = 0; i < arr1.length; i++) {
		        	System.out.print(arr1[i] + " ");
		        }
		        System.out.println("\n");
		        System.out.println("updated array:");
				for(int i = 0; i < 4; i++) {
					for (int j = 0; j < 7; j++) {
						System.out.print(arr[i][j] + " ");
					}
					System.out.println();
				}
	        }
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		int[][] arr = {{9, 12, 6, 14, 10, 21, 13}, {3, 5, 41, 16, 14, 10, 21}, {3, 15, 41, 17, 11, 10, 51}, {3, 15, 41, 17, 11, 10, 51}};
		
		Thread t0 = new Thread(new MyThread(0, arr));
		Thread t1 = new Thread(new MyThread(1, arr));
		Thread t2 = new Thread(new MyThread(2, arr));
		Thread t3 = new Thread(new MyThread(3, arr));
		t0.start();
		t1.start();
		t2.start();
		t3.start();
	}

}
