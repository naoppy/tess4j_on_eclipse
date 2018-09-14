import java.util.Scanner;

public class UnionFind {
	final static int MAX_N = Integer.MAX_VALUE;
	static int[] par = new int[MAX_N];
	static int[] rank = new int[MAX_N];
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
		}
	}
	static int root(int x) {
		if(par[x]==x) {
			return x;
		} else {
			return par[x] = root(par[x]);
		}
	}
	static boolean same(int x, int y) {
		return root(x)==root(y);
	}
	static void unite(int x, int y) {
		x = root(x);
		y = root(y);
		if(x == y) return;

		if(rank[x] < rank[y]) {
			par[x] = y;
		} else {
			par[y] = x;
			if(rank[x]==rank[y]) rank[x]++;
		}
	}
}
