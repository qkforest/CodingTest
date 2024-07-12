import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[][] dp = new long[n+1][2];
		for(int i = 1; i <= n; i++) {
			int score = Integer.parseInt(br.readLine());
			dp[i][0] = score;
			dp[i][1] = score;
		}
		if(n == 1) {
			System.out.println(dp[1][0]);
		}
		else {
			dp[1][1] = 0;
			dp[2][0] += dp[1][0];
			for(int i = 3; i <= n; i++) {
				dp[i][0] += dp[i-1][1];
				dp[i][1] += Math.max(dp[i-2][0], dp[i-2][1]);
			}
			System.out.println(Math.max(dp[n][0], dp[n][1]));
		}
	}
}