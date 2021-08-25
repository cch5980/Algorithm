package lv2;

public class Programmers_멀쩡한사각형 {
	public static void main(String[] args) {
		long w = 8; long h = 12;
		long gcd_num;
		// 최대 공약수 구하기
		if(w >= h) gcd_num = gcd(w,h);
		else gcd_num = gcd(h,w);
		
		long N = w/gcd_num;
		long M = h/gcd_num;
		long cutting_part = (N+M-1)*gcd_num;
		System.out.println(w*h-cutting_part);
		
	}
	
	static long gcd(long a, long b) {
		while(b != 0) {
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
}
