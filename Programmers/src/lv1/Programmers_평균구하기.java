package lv1;

public class Programmers_평균구하기 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += arr[i];
		}
		System.out.println(avg/arr.length);
	}
}
