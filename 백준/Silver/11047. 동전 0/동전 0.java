import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		Integer[] money = new Integer[N];
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(money, (a, b) -> b - a);
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(K == 0) {
				break;
			} else {
				if(K >= money[i]) {
					answer += (K / money[i]);
					K %= money[i];
				}
			}
		}
		System.out.println(answer);
	}
}