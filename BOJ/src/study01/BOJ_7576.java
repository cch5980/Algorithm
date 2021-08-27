package study01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7576 {
	static int M, N;	// 행,열
	static int[][] map;
	static boolean[][] visited;
	static int[][] pos = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<int[]> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		// input
		map = new int[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scan.nextInt();
				if(map[i][j] == 1) queue.add(new int[] {i,j});
			}
		}

		int day = bfs();
		int result = checkRawTomatos() ? -1 : day;
		System.out.println(result);
	}
	
	// ripen tomato
	static int bfs() {
		int day = 0;
		while(!queue.isEmpty()) {
			day++;
			int qSize = queue.size();
			for (int i = 0; i < qSize; i++) {
				int[] node = queue.poll();
				visited[node[0]][node[1]] = true;
				for (int p = 0; p < pos.length; p++) {
					int nr = node[0] + pos[p][0];
					int nc = node[1] + pos[p][1];
					if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						queue.add(new int[] {nr, nc});
					}
				}
			}
		}
		return day-1;
	}
	
	// check raw tomato
	static boolean checkRawTomatos() {
		boolean isRawTomato = false;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					isRawTomato = true;
					break;
				}
			}
		}
		return isRawTomato;
	}
	
	
}
