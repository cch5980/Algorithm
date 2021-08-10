package study01;

import java.util.Scanner;

public class BOJ_1717_repeat {
	static int[] parents = new int[1000001];
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		
		for (int i = 1; i <= N; i++) parents[i] = i;
		
		for (int i = 0; i < M; i++) {
			int command = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			switch (command) {
			case 0:	// 합집합
				union(a, b);
				break;
			case 1:
				String answer = (find(a) == find(b)) ? "YES" : "NO";
				System.out.println(answer);
				break;
			}
		}
	}
	
	static int find(int x) {
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a < b) parents[b] = a;
		else parents[a] = b;
	}
}
