package study01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_13604 {
	static class Person implements Comparable<Person> {
		int id, score;

		public Person(int id, int score) {
			this.id = id;
			this.score = score;
		}

		@Override
		public int compareTo(Person o) {
			if(this.score < o.score) return 1;
			else if(this.score > o.score) return -1;
			else {
				if(this.id < o.id) return 1;
				else return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int J = scan.nextInt();	// 인원 수
		int R = scan.nextInt();	// 라운드 수
		ArrayList<Person> list = new ArrayList<Person>();
		for (int i = 0; i < J; i++) list.add(new Person(i+1, 0));	// 초기화
		
		for (int r = 0; r < R; r++) {
			for (int j = 0; j < J; j++) {
				list.get(j).score += scan.nextInt();
			}
		}
		
		Collections.sort(list);	// 내림차순
		System.out.println(list.get(0).id);
	}
}