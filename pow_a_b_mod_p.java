import java.util.Scanner;

public class pow_a_b_mod_p {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		//	a^b (mod p)
		//calc(int a, int b, int p)
		//b==0
		//	return 1
		//bが偶数
		//	int d = calc(a, b/2, p)
		//	return d * d % p
		//bが奇数
		//	return (a * calc(a, b-1, p) % p
		int mod = 1000000007;
	}
	static long func(long a, long b, int mod) {
		if(b == 0) return 1;
		if(b % 2 == 0) return func(a * a % mod, b / 2, mod);
		else return a * func(a, b - 1, mod) % mod;
	}
}
