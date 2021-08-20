package lv2;

public class Programmers_문자열압축 {
	public static void main(String[] args) {
		String s = "xababcdcdababcdcd";
		int result = Integer.MAX_VALUE;
		
		// 문자열 길이의 절반만큼 순회
		// 문자열 한개인 것도 고려해야한다. 문자열 길이가 1인 상황에서 2로 나누면 몫이 0이 나온다.
		for (int i = 1; i <= s.length()/2+1; i++) {
			String chkStr = s.substring(0, i);	// 기준이 될 문자열
			int count = 1;	// 카운트 하나 올리고 들어간다.
			String compactStr = "";	
			
			// 문자열 검사 => 연속해서 중복된 문자열을 찾자!
			// 문자열 i개 단위로 순회
			int j = 0;
			for (j = i; j <= s.length()-i; j+=i) {
				String tmpStr = s.substring(j, j+i);
				if(chkStr.equals(tmpStr)) {
					// 같은 문자열이면 카운트 증가
					count++;
				} else {
					// 같지 않으면 압축 결과 문자열에 붙인다.
					if(count > 1) compactStr += Integer.toString(count);
					compactStr += chkStr;
					chkStr = s.substring(j, j+i);
					count = 1;
				}
			}
			if(count > 1) compactStr += Integer.toString(count);
			compactStr += chkStr;
			if(s.length() > j) compactStr += s.substring(j, s.length());
			// 가장 짧은 문자열을 찾는다!
			result = Math.min(result, compactStr.length());
			
		}
		System.out.println(result);
	}
}
