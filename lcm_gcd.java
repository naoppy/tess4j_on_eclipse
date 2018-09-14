
public class lcm_gcd {
	static int gcd(int a, int b) {//最大公約数を求める
		if(b == 0) return a;
		return gcd(b, a%b);
	}
	static int lcm(int a, int b) {//最小公倍数を求める
		int g = gcd(a, b);//まず最大公約数を求める
		return a / g * b;//ユークリッドの互除法により
		// a*b = (aとbの最小公倍数) * (aとbの最大公約数)
		//式変形して	a / (aとbの最大公約数) * b = (aとbの最小公倍数)
		//これで最小公倍数が求まる
	}
}
