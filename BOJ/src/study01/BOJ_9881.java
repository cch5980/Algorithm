package study01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9881 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] hills_Arr = new int[N];	// 언덕높이를 담을 배열
		for (int i = 0; i < N; i++) hills_Arr[i] = scan.nextInt();
		Arrays.sort(hills_Arr);	// 오름차순으로 정렬
		
		int result = Integer.MAX_VALUE;
		// (0~17), (1~18), (2~19), ... (82~99), (83~100)
		// 전체 구간을 조사하면서 언덕들을 깍거나 보충한다.
		// 그랬을때 가장 작은 공사 비용인 지점을 찾아낸다.
		for (int i = 0; i <= 83; i++) {
			int cost = 0;	// 총 공사비
			int work = 0;	// 공사해야할 높이
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