package study01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class BOJ_9881 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] hills_Arr = new int[N];
		for (int i = 0; i < N; i++) {
			hills_Arr[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(hills_Arr));
		Arrays.sort(hills_Arr);
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= 83; i++) {
			int cost = 0;
			int work = 0;
			for (int j = 0; j < N; j++) {
				int hill_height = hills_Arr[j];
				if(i > hill_height) {
					work = i - hill_height;
				} else if(i+17 < hill_height) {
					work = hill_height - (i+17);
				} else {
					work = 0;
				}
				cost += (work * work);
			}
			result = Math.min(result, cost);
		}
		System.out.println(result);
	}
}
