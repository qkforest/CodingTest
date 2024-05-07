import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MOD = 10007;
		long[][] dp = new long[N+1][10];
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = j; k < 10; k++) {
					dp[i][j] += dp[i-1][k];
					dp[i][j] %= MOD;
				}
			}
		}
		long answer = 0;
		for(long ans : dp[N]) {
			answer += ans;
		}
		System.out.println(answer % MOD);
	}
}