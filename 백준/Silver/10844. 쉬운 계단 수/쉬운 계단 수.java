import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[101][10];
		for(int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i-1][1] % 1000000000;
			for(int j = 1; j < 9; j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			}
			dp[i][9] = dp[i-1][8] % 1000000000;
		}
		long answer = 0;
		for(int i = 0; i < 10; i++) {
			answer += dp[N][i] % 1000000000;
		}
		System.out.print(answer % 1000000000);
	}
}