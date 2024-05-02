import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] num = new int[T];
		int max = 0;
		for(int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(br.readLine());
			max = Math.max(num[i], max);
		}
		int[] dp = new int[max+1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 4; i <= max; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		for(int n : num) {
			System.out.println(dp[n]);
		}
	}
}