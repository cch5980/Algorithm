package lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_더맵게 {	
	public static void main(String[] args) {
		int[] scovilie = {1, 1, 1};
		int K = 4;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : scovilie) pq.add(i);
		
		int answer = 0;
		while(pq.peek() < K) {
			printPQ(pq);
			if(pq.size() < 2) {
				answer = -1;
				break;
			}
			int food1 = pq.poll();
			int food2 = pq.poll();
			int new_food = food1 + (food2 * 2);
			
			pq.add(new_food);
			answer++;
		}
		System.out.println(answer);
	}
	
	static void printPQ(PriorityQueue<Integer> pq) {
		System.out.println(Arrays.toString(pq.toArray()));
	}
}
