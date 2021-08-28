package lv2;

import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_기능개발 {
	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		ArrayList<Integer> list = new ArrayList<>();
		
		int idx = 0;
		while(idx < progresses.length) {
			int count = 0;
			for (int i = 0; i < speeds.length; i++) {
				progresses[i] += speeds[i];
				if(progresses[idx] >= 100) {
					System.out.println("idx: " +idx);
					count++;
					idx++;
				}
			}
			if(count > 0) list.add(count);
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		System.out.println(Arrays.toString(result));
	}
}
