package study01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10021 {
	static int[] parents;	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Edge> list = new ArrayList<>();
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				int distance = (int) (Math.pow(arr[i][0]-arr[j][0], 2) + Math.pow(arr[i][1]-arr[j][1], 2));
				// 두 관개시스템 간의 거리가 C보다 작으면 간선에서 제외
				if(distance >= C) list.add(new Edge(i,j,distance));
			}
		}
		
		// 크루스칼 알고리즘 사용!
		// 두 정점 사이의 간선의 길이가 작은 기준으로 정렬
		Collections.sort(list);
		
		// 집합 초기화
		parents = new int[N];
		for(int i=0; i<N; i++) makeSet(i);
		
		int result = 0;	// MST 간선 길이의 총합
		int count = 0;	// MST 정점의 개수
		for (int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			int a = findSet(edge.a);
			int b = findSet(edge.b);
			if(a == b) continue;
			unionSet(a, b);
			result += edge.distance;
			count++;
		}
		int answer = (count == N-1) ? result : -1;
		System.out.println(answer);
	}
	
	// 집합 초기화
	static void makeSet(int x) {
		parents[x] = x;
	}
	
	// 집합 부모 찾기
	static int findSet(int x) {
		if(parents[x] == x) return x;
		return parents[x] = findSet(parents[x]);
	}
	
	// 집합 합치기
	static void unionSet(int a, int b) {
		a = parents[a];
		b = parents[b];
		if(a < b) parents[b] = a;
		else parents[a] = b;
	}
	
	// 정점을 잇는 간선 객체
	static class Edge implements Comparable<Edge> {
		int a, b, distance;	// 정점1, 정점2, 정점 사이의 간선 길

		public Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge e) {
			return this.distance - e.distance;
		}
	}
	
}
