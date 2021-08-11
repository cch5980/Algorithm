package study01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal {
	static int[] parents;
	public static void main(String[] args) {
		Scanner scan = new Scanner("7 11\n" +
                "0 1 31\r\n" + 
                "0 2 31\r\n" + 
                "0 6 31\r\n" + 
                "0 5 60\r\n" +
                "1 2 21\r\n" + 
                "2 4 46\r\n" + 
                "2 6 25\r\n" + 
                "3 4 34\r\n" + 
                "4 6 51\r\n" + 
                "5 3 18\r\n" + 
                "5 4 40\r\n" ); 	
		
		int V = scan.nextInt();	// 정점
		int E = scan.nextInt();	// 간선
		int[][] graphArr = new int[E][3];
		for (int i = 0; i < E; i++) {
			graphArr[i][0] = scan.nextInt();
			graphArr[i][1] = scan.nextInt();
			graphArr[i][2] = scan.nextInt();
		}
		
		Arrays.sort(graphArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		
		int result = 0;
		for (int i = 0; i < E; i++) {
			int a = findSet(graphArr[i][0]);
			int b = findSet(graphArr[i][1]);
			if(a==b)
				continue;
			unionSet(a,b);
			result += graphArr[i][2];
			System.out.println(i+"번째 : " + Arrays.toString(parents));
		}
		System.out.println(result);
	}
	
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	static int findSet(int x) {
		if(parents[x] == x) {
			return x;
		}
		parents[x] = findSet(parents[x]);
		return parents[x];
	}
	
	static void unionSet(int x, int y) {
		int px = parents[x];
		int py = parents[y];
		if(px!=py) {
			parents[py] = parents[px];
		}
	}
}
