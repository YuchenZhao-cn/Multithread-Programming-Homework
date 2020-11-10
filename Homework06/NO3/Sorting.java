package YuchenZhao.NO3;

import java.util.ArrayList;
import java.util.Arrays;

public class Sorting {

	public static int[][] arr = { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21}, 
			   { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
			   { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42} }; 
	public static ArrayList<int[]> arrays = new ArrayList<int[]>();

	public static void main(String[] args) {
		for(int i = 0; i < 6; i++) {
			arrays.add(arr[i]);
		}
		System.out.println("-----Sorting-----");
		arrays.parallelStream().forEach(x -> {Arrays.sort(x); for(int c : x) {System.out.print(c + " ");} System.out.println("\n" + Thread.currentThread().getName() + " completed!!!");});
		System.out.println("\n-----Sorted array-----");
		for(int[] c : arr) {
			for(int d : c)
				System.out.print(d + " ");
			System.out.println();
		}
	}
}