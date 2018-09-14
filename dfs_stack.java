import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Scanner;

public class dfs_stack {
	public static void main(String[] args) {
		int[] y = {0, 1, 0, -1};
		int[] x = {1, 0, -1, 0};
		final Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] map = new char[h][w];
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
		ArrayDeque<Point> deq = new ArrayDeque<>();
		Point start = new Point(starth, startw);
		Point goal = new Point(goalh, goalw);
		deq.push(start);
		while(deq.size()!=0) {
			Point p = deq.poll();
			if(p.equals(goal)) {
				System.out.println("Yes");
				return;
			}
			if(p.x >= h || p.x < 0 || p.y >= w || p.y < 0) {
				continue;
			}
			if(map[p.x][p.y] == '#') {
				continue;
			}
			map[p.x][p.y] = '#';
			for(int i = 0; i < 4; i++) {
				deq.push(new Point(p.x + x[i], p.y + y[i]));
			}
		}
		System.out.println("No");
	}
}
