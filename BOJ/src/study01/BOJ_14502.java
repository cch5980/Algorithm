package study01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14502 {
	static int N, M;
	static int[][] map;	// 맵
	static int[][] tmpMap;	// 복사해서 바이러스 퍼트릴 맵
	static boolean[][] visited;
	static int[][] pos_arr = {{-1,0},{1,0},{0,-1},{0,1}};	// 상,하,좌,우
	static Queue<int[]> queue = new LinkedList<>();
	static ArrayList<int[]> virus_pos_list = new ArrayList<>();	// 초기 바이러스 위치
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scan.nextInt();
				// 입력 받을 때 바이러스 위치 저장
				if(map[i][j] == 2) virus_pos_list.add(new int[] {i, j});
			}
		}
		// 벽 세우기
		installWalls(0);
		System.out.println(result);
	}
	
	static void installWalls(int wall_count) {
		if(wall_count == 3) {
			copyMap();		// 맵 복사
			spread_virus();		// 바이러스 퍼트리기
			get_safety_zone();	// 안전영역 찾기
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					installWalls(wall_count+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void copyMap() {
		visited = new boolean[N][M];
		tmpMap = new int[N][M];
		for (int i = 0; i < N; i++) tmpMap[i] = map[i].clone();
	}
	
	static void spread_virus() {
		queue.clear();
		for (int[] virus : virus_pos_list) {
			queue.add(new int[] {virus[0], virus[1]});
		}
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			int r = pos[0];
			int c = pos[1];
			visited[r][c] = true;
			tmpMap[r][c] = 2;
			for (int i = 0; i < pos_arr.length; i++) {
				int nr = r + pos_arr[i][0];
				int nc = c + pos_arr[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc<M && tmpMap[nr][nc] == 0 && !visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
				}
			}
		}
	}
	
	static void get_safety_zone() {
		int safe_count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmpMap[i][j] == 0) {
					safe_count++;
				}
			}
		}
		result = Math.max(result, safe_count);
	}
	
}
