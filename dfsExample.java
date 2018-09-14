import java.util.Scanner;

public class dfsExample {
	static boolean[] vis;
	static boolean[][] graph;
	static int n;
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		//宣言と初期化
		n = sc.nextInt();//頂点数
		int m = sc.nextInt();//辺の数
		int[] a = new int[m];//辺の片方
		int[] b = new int[m];//辺の片方
		graph = new boolean[n][n];//a to bの橋があるかTorF
		vis = new boolean[n];//n個目の頂点を訪れたかTorF
		//入力
		for(int i = 0; i < m; i++) {
			a[i] = sc.nextInt() - 1;
			b[i] = sc.nextInt() - 1;
			graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;
		}
		//solve
		long ans = 0;
		for(int i = 0; i < m; i++) {//m回 = 辺の数だけ回す
			for(int j = 0; j < n; j++) {//全ての頂点を訪れていない
				vis[j] = false;
			}
			graph[a[i]][b[i]] = graph[b[i]][a[i]] = false;//i本目の橋切断
			/*
			 * dfsで頂点をできるだけ訪れる
			 */
			dfs(0);//頂点0から探索

			boolean isBridge = false;
			for(int j = 0; j < n; j++) {//全ての頂点を訪れたか判定
				if(!vis[j]) {
					isBridge = true;
				}
			}
			if(isBridge) ans++;
			graph[a[i]][b[i]] = graph[b[i]][a[i]] = true;//橋復活
		}
		System.out.println(ans);
	}
	static void dfs(int x) {
		if(vis[x]) return;//2周目なら終わる
		vis[x] = true;//訪れる
		for(int i = 0; i < n; i++) {
			if(graph[x][i]==false) continue;
			dfs(i);
		}
	}
}