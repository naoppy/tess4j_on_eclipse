import java.util.Arrays;
import java.util.Scanner;

public class Bellman_ford {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		V = n;
		E = m;
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			edges[i] = new Edge();
			edges[i].from = sc.nextInt() - 1;
			edges[i].to = sc.nextInt() - 1;
			edges[i].cost = -sc.nextInt();
		}
		System.out.println();
	}
	//辺を表すクラス
	static class Edge {
		int from;//出発元の頂点
		int to;//到達先の頂点
		int cost;//距離
	}
	static int V;//頂点の数
	static int E;//辺の数
	static Edge[] edges;
	static int[] d;//頂点毎の暫定的な最短距離
	static int INF = Integer.MAX_VALUE / 2;
	/*
	 * 始点を指定して各頂点の最短距離を取得する
	 * @param sv 始点とする頂点
	 */
	static void bellman_ford(int sv) {
		//最短距離の初期化
		d = new int[V];
		Arrays.fill(d, INF);
		d[sv] = 0;

		//更新が終わるまで頂点を繰り返し操作していく
		while(true) {
			boolean update = false;
			for(int i = 0; i < E; i++) {
				int u = edges[i].from;
				int v = edges[i].to;
				int c = edges[i].cost;
				//もし、始点からuまでの最短距離 + uからvまでの距離cが始点からvまでの距離より小さいなら更新する
				if(d[u] + c < d[v]) {
					d[v] = d[u] + c;
					update = true;
				}
			}
			if(!update) {
				break;
			}
		}
	}

	static boolean bellman_ford2(int sv) {//負の閉路検出用
		//最短距離の初期化
		d = new int[V];
		Arrays.fill(d, INF);
		d[sv] = 0;
		//更新が終わるまで頂点を繰り返し操作していく
		for(int count = 0; count < V; count++) {
			for(int i = 0; i < E; i++) {
				int u = edges[i].from;
				int v = edges[i].to;
				int c = edges[i].cost;
				//もし、始点からuまでの最短距離 + uからvまでの距離cが始点からvまでの距離より小さいなら更新する
				if(d[u] + c < d[v]) {
					d[v] = d[u] + c;
					if(count==v-1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
