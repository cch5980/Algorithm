package study01;

import java.util.Scanner;

public class BOJ_1439 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		int zero = 0;
		int one = 0;
		char temp = str.charAt(0);	// 첫번째 값
		
		if(temp == '0') zero++;	// 첫번째 값이 0이라면 zero++
		else one++;	// 첫번째 값이 1이라면 one++
		
		for (int i = 1; i < str.length(); i++) {
			if(str.charAt(i) != temp) {	// 연속하지 않는다면
				if(temp == '0') one++;
				else zero++;
				temp = str.charAt(i);
			}
		}
		System.out.println(Math.min(zero, one));
	}
}
