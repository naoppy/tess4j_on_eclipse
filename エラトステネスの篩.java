import java.util.Scanner;

public class エラトステネスの篩 {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//入力された数までの素数を判定
		int wantUpper = n;
		int furui[] = new int[wantUpper+1];

		for(int i = 2; i <= wantUpper; i++) {
			furui[i]=i;//篩に2~nまでの値を入れる
		}
		for(int i = 2; i <= Math.sqrt(wantUpper); i++) {
			for(int j = i+i; j <= wantUpper; j+=i) {//iの倍数は篩落とす
				furui[j]=0;
			}
		}
		//篩の0ではない値が全て素数
	}
}
