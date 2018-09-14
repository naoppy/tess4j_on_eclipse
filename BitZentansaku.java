public class BitZentansaku {
	public static void main(String[] args) {

		int ketasu = 4;//桁の数 4なら0000 ~ 1111まで
		for(int i = 0; i < (1<<ketasu); i++) {

			for(int j = ketasu-1, k = 0; j >= 0; j--, k++) {
				if(((i>>j) & 1) == 1) {//左からj番目のbitが立っている(1)かどうか

				}
			}

			for(int j = 0; j < ketasu; j++) {
				if(((i>>j) & 1) == 1) {//右からj番目のbitが立っている(1)かどうか

				}
			}

		}

	}
}
