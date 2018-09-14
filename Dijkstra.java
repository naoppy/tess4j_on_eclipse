import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

//http://nishiharayuugo.blog.fc2.com/blog-entry-15.html

public class Dijkstra {//頂点数V、辺の数Eに対し、O(E log V)
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		System.out.println();
	}

	//候補クラス
	static class Candidate implements Comparable<Candidate> {
		int d;//距離
		int v;//頂点

		public Candidate(int v, int d) {
			this.d = d;
			this.v = v;
		}
		//距離が短いほど優先する
		@Override
		public int compareTo(Candidate o) {
			return this.d - o.d;
		}
	}

	//辺クラス
	static class Edge {
		int to;//どの頂点へ伸びているか
		int cost;//距離

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static List<List<Edge>> G;//隣接リストで表現したグラフ

	static int[] dist;//最短距離(仮定も含む)

	static int INF = Integer.MAX_VALUE / 2;

	/*
	 * @param sv 始点となる頂点
	 */
	static void dijkstra(int sv) {
		//初期化
		Arrays.fill(dist, INF);
		dist[sv] = 0;

		//候補の優先キューを用意
		Queue<Candidate> candidates = new PriorityQueue<>();
		candidates.offer(new Candidate(sv, 0));//最初に始点と距離0の候補を入れておく

		while(!candidates.isEmpty()) {
			//候補を取り出す
			Candidate c = candidates.poll();
			int v = c.v;
			int d = c.d;

			//意味の無い情報を捨てる
			if(dist[v] < d) {
				continue;
			}

			//確定した頂点から伸びている各辺についてみていく
			List<Edge> edges = G.get(v);
			for(Edge e : edges) {
				if(dist[e.to] > dist[v] + e.cost) {
					dist[e.to] = dist[v] + e.cost;
					candidates.offer(new Candidate(e.to, dist[e.to]));
				}
			}
		}
	}
}
