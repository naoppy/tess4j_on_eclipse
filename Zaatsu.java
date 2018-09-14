import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.TreeSet;

public class Zaatsu {
	FastScanner in = new FastScanner(System.in);
	PrintWriter out = new PrintWriter(System.out);

	int lower_bound(int[] a, int key) {
		int x = Arrays.binarySearch(a, key);
		if (x >= 0)
			return x;
		else {
			return -(x + 1);
		}
	}

	int upper_bound(int[] a, int key) {
		int x = Arrays.binarySearch(a, key);
		if (x >= 0)
			return x;
		else {
			return -(x + 2);
		}
	}

	public void run() {
		int n = in.nextInt(), m = in.nextInt();
		int[] X = new int[n];//純粋入力
		int[] Y = new int[n];

		TreeSet<Integer> xset = new TreeSet<Integer>();//純粋入力から重複を排除したもの
		TreeSet<Integer> yset = new TreeSet<Integer>();
		for (int i = 0; i < n; i++) {
			X[i] = in.nextInt();
			Y[i] = in.nextInt();
			xset.add(X[i]);
			yset.add(Y[i]);
		}

		xset.add(Integer.MIN_VALUE);//各setにminとmaxを入れてバグるのを防ぐ
		xset.add(Integer.MAX_VALUE);
		yset.add(Integer.MIN_VALUE);
		yset.add(Integer.MAX_VALUE);

		HashMap<Integer, Integer> xmap = new HashMap<Integer, Integer>();
		//xmap<i, j>…数値iは小さい順でj番目
		HashMap<Integer, Integer> ymap = new HashMap<Integer, Integer>();

		int[] xpos = new int[xset.size()];//ユニークな座標の個数とる//重複を取った純粋入力
		int[] ypos = new int[yset.size()];//xpos[i]…i番目に小さい数//これは実質TreeSetを配列に変換しただけ

		for (int xs : xset) {
			xpos[xmap.size()] = xs;//posにTreeSetから順番に入れていく
			if (!xmap.containsKey(xs))
				xmap.put(xs, xmap.size());//<数値、順番>
		}
		for (int ys : yset) {
			ypos[ymap.size()] = ys;
			if (!ymap.containsKey(ys))
				ymap.put(ys, ymap.size());
		}

		int W = xmap.size(), H = ymap.size();
		int[][] dp = new int[H][W];//累積和用テーブル

		for (int i = 0; i < n; i++) {
			dp[ymap.get(Y[i])][xmap.get(X[i])]++;
		}
		//累積和
		for (int i = 0; i < H - 1; i++) {
			for (int j = 0; j < W - 1; j++) {
				dp[i + 1][j + 1] = dp[i + 1][j + 1] + dp[i + 1][j] + dp[i][j + 1] - dp[i][j];
			}
		}
		//クエリ処理
		for (int i = 0; i < m; i++) {
			int lx = lower_bound(xpos, in.nextInt());//左上はlower_bound
			int ly = lower_bound(ypos, in.nextInt());
			int rx = upper_bound(xpos, in.nextInt());//右下はupper_bound
			int ry = upper_bound(ypos, in.nextInt());
			//累積和から出力
			out.println(dp[ry][rx] + dp[ly - 1][lx - 1] - dp[ry][lx - 1] - dp[ly - 1][rx]);
		}
		out.close();
	}

	public static void main(String[] args) {
		new Zaatsu().run();
	}

	public void mapDebug(int[][] a) {
		System.out.println("--------map display---------");

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%3d ", a[i][j]);
			}
			System.out.println();
		}

		System.out.println("----------------------------");
		System.out.println();
	}

	public void debug(Object... obj) {
		System.out.println(Arrays.deepToString(obj));
	}

	class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		int[] nextIntArray(int n) {
			int[] array = new int[n];
			for (int i = 0; i < n; i++)
				array[i] = nextInt();

			return array;
		}

		int[][] nextIntMap(int n, int m) {
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextIntArray(m);
			}
			return map;
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		long[] nextLongArray(int n) {
			long[] array = new long[n];
			for (int i = 0; i < n; i++)
				array[i] = nextLong();

			return array;
		}

		long[][] nextLongMap(int n, int m) {
			long[][] map = new long[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextLongArray(m);
			}
			return map;
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		double[] nextDoubleArray(int n) {
			double[] array = new double[n];
			for (int i = 0; i < n; i++)
				array[i] = nextDouble();

			return array;
		}

		double[][] nextDoubleMap(int n, int m) {
			double[][] map = new double[n][m];
			for (int i = 0; i < n; i++) {
				map[i] = in.nextDoubleArray(m);
			}
			return map;
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String[] nextStringArray(int n) {
			String[] array = new String[n];
			for (int i = 0; i < n; i++)
				array[i] = next();

			return array;
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
