import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+2][3];
		int answer = 0;
		for(int i = 2; i < N+2; i++) {
			int a = Integer.parseInt(br.readLine());
			dp[i][0] = answer;
			dp[i][1] = Math.max(dp[i-2][0], Math.max(dp[i-2][1], dp[i-2][2])) + a;
			dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1]) + a;
			answer = Math.max(answer, Math.max(dp[i][1], dp[i][2]));
		}
		System.out.print(answer);
	}
}