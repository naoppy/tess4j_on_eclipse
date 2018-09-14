import java.util.ArrayList;
import java.util.Collections;

public class binarySearch {
	public static void main(String[] args) {
		/*
		 * ListVer
		 **/
		ArrayList<Integer> array = new ArrayList<>();
		int key = 3;
		long ok1;
		long ok2;
		//lower_bound
		ok1 = Collections.binarySearch(array, key, (Integer x, Integer y) ->  (x.compareTo(y) >= 0 ? 1 : -1));
		ok1 = ok1 >= 0 ? ok1 : ~ok1;
		//upper_bound
		ok2 = Collections.binarySearch(array, key, (Integer x, Integer y) ->  (x.compareTo(y) > 0 ? 1 : -1));
		ok2 = ok2 >= 0 ? ok2 : ~ok2;

		/*
		 * NormalVer
		 */
		long array1[] = new long[1000];
		long Tmax = 999;
		long Tmin = 0;
		long T = 0;
		long want = 3;
		while(Tmax - Tmin > 1) {
			T = Tmin + (Tmax-Tmin)/2;
			//Tを使って判定など
			if(array1[(int)T] > want) {
				Tmin = T;
			} else {//同じ場合はTmaxを変更
				Tmax = T;
			}
		}
		long ans = Tmax;
	}
}