import java.util.Scanner;

public class nCr {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long r = sc.nextLong();
		//nCr = n!/r!(n-r)! = n ~ r / (n-r)!
		long n_r = n - r;
		System.out.println(String.format("n:%d\nr:%d\nn-r:%d", n, r, n_r));
		long a = 1, b = 1;
		int mod = 1000000007;
		for(int i = 1; i <= n_r; i++) {
			a = a * (r + i) % mod;
			b = b * i % mod;
		}
		long ans = a * func(b, mod - 2, mod) % mod;
		System.out.println(ans);
	}
	static long func(long a, long b, int mod) {
		if(b == 0) {
			return 1;
		}
		if(b % 2 == 0) {
			return func(a * a % mod, b / 2, mod);
		} else {
			return a * func(a, b-1, mod) % mod;
		}
	}
}
