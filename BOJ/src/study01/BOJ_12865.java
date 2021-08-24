package study01;

import java.util.Scanner;

public class BOJ_12865 {
	static int[] weight_arr, value_arr;
	static int N,K;
	static int[][] memo;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		K = scan.nextInt();
		
		weight_arr = new int[N];
		value_arr = new int[N];
		memo = new int[N+1][K+1];
		
		for (int i = 0; i < N; i++) {
			weight_arr[i] = scan.nextInt();
			value_arr[i] = scan.nextInt();
		}
		System.out.println(knapsack(0,0));
		
	}
	
	static int knapsack(int weight, int idx) {
		if(memo[idx][weight] > 0) return memo[idx][weight];
		if(idx == N) return 0;
		int n1 = 0;
		if(weight + weight_arr[idx] <= K)
			n1 = value_arr[idx] + knapsack(weight + weight_arr[idx], idx+1); // 포함
		int n2 = knapsack(weight, idx+1); // 미포함
		return memo[idx][weight] = Math.max(n1, n2);
	}
}