import java.awt.Point;
import java.util.Scanner;

public class dfs_saiki {
	static int[] y = {0, 1, 0, -1};
	static int[] x = {1, 0, -1, 0};
	static int h;
	static int w;
	static char[][] map;
	static Point goal;
	static boolean[][] visited;
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		map = new char[h][w];
		visited = new boolean[h][w];
		int starth = 0, startw = 0;
		int goalh = 0, goalw = 0;
		for(int i = 0; i < h; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < w; j++) {
				if(map[i][j] == 's') {
					starth = i; startw = j;
				} else if(map[i][j] == 'g') {
					goalh = i; goalw = j;
				}
			}
		}
		dfs(new Point(starth, startw));
		System.out.println(visited[goalh][goalw] ? "Yes" : "No");
	}
	static void dfs(Point p) {
		if(p.x >= h || p.x < 0 || p.y >= w || p.y < 0) {
			return;
		}
		if(map[p.x][p.y] == '#') {
			return;
		}
		if(visited[p.x][p.y]) {
			return;
		}
		visited[p.x][p.y] = true;
		for(int i = 0; i < 4; i++) {
			dfs(new Point(p.x + x[i], p.y + y[i]));
		}
	}
}
