package lv1;

public class Programmers_신규아이디추천 {
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		char[] new_id_char = new_id.toCharArray();

		// step1,2
		String step1_2 = "";
		for (int i = 0; i < new_id_char.length; i++) {
			// step1
			char c = Character.toLowerCase(new_id_char[i]);
			// step2: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
			if(!(('a' <= c && 'z' >= c) || (c >= '0' && c <= '9') || c == '-' || c=='_' || c=='.')) {
				continue;
			}
			step1_2 += c;
		}
		System.out.println("step12: " + step1_2);
		
		// step3
		String step3 = "";
		boolean dotFlag = false;
		for (int i = 0; i < step1_2.length(); i++) {
			char c = step1_2.charAt(i);
			if(c == '.') {
				if(dotFlag) {
					continue;
				} else {
					step3 += c;
					dotFlag = true;
				}
			} else {
				step3 += c;
				dotFlag = false;
			}
		}
		System.out.println("step3: " +step3);
		
		// step4
		String step4 = step3;
		if(step3.length() > 0 && step3.charAt(0)== '.') {
			step4 = step3.substring(1, step3.length());
		}
		String step5 = step4;
		if(step4.length() > 0 && step4.charAt(step4.length()-1) == '.') {
			step5 = step4.substring(0, step4.length()-1);
		}
		System.out.println("step4: " + step5);
		
		// step5
		if(step5.length() == 0) {
			step5 += 'a';
		}
		System.out.println("step5: " + step5);
		
		// step6
		String step6 = step5;
		if(step5.length() >= 16) {
			if(step5.charAt(14) == '.') {
				step6 = step5.substring(0, 14);
			} else {
				step6 = step5.substring(0, 15);
			}			
		} 
		System.out.println("step6: " +  step6);
		
		// step7
		String step7 = step6;
		if(step6.length() <= 2) {
			char lastChar = step6.charAt(step6.length()-1);
			for (int i = step6.length(); i < 3; i++) {
				step7 += lastChar;
			}
		}
		
		System.out.println(step7);
	}
}
