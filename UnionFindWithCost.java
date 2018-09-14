import java.util.Scanner;

public class UnionFindWithCost {
	final static int MAX_N = Integer.MAX_VALUE;
	static int[] par = new int[MAX_N];
	static int[] rank = new int[MAX_N];
	static int[] diff_weight = new int[MAX_N];
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		init(n);
		System.out.println();
	}
	static void init(int n) {
		for(int i = 0; i < n; i++) {
			par[i] = i;
			rank[i] = 0;
			diff_weight[i] = 0;
		}
	}
	static int root(int x) {
		if(par[x]==x) {
			return x;
		} else {
			int r = root(par[x]);
			diff_weight[x] += diff_weight[par[x]];//累積和を取る
			return par[x] = r;
		}
	}
	static boolean same(int x, int y) {
		return root(x)==root(y);
	}
	static boolean unite(int x, int y, int w) {
		//xとyそれぞれについて、rootとの重み差分を補正
		w += (weight(x)-weight(y));

		x = root(x);
		y = root(y);
		if(x == y) {
			if(diff(x, y)==w) {
				return true;
			} else {
				return false;//矛盾が発生
			}
		}

		//rank[x] >= rank[y]になるようにswap
		if(rank[x] < rank[y]) {
			int temp = x;
			x = y;
			y = temp;
			w = -w;
		}

		if(rank[x] == rank[y]) rank[x]++;
		par[y] = x;

		diff_weight[y] = w;

		return true;
	}
	static int weight(int x) {
		root(x);
		return diff_weight[x];
	}
	static int diff(int x, int y) {
		return weight(y) - weight(x);
	}
}
