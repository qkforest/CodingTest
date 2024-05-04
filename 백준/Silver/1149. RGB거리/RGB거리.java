import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][3];
		int MOD = 10007;
		String[] s = br.readLine().split(" ");
		dp[1][0] = Integer.parseInt(s[0]);
		dp[1][1] = Integer.parseInt(s[1]);
		dp[1][2] = Integer.parseInt(s[2]);
		for(int i = 2; i <= N; i++) {
			s = br.readLine().split(" ");
			dp[i][0] = Integer.parseInt(s[0]) + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = Integer.parseInt(s[1]) + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = Integer.parseInt(s[2]) + Math.min(dp[i-1][0], dp[i-1][1]);

		}
		int answer = Math.min(dp[N][0], dp[N][1]);
		answer = Math.min(dp[N][2], answer);
		System.out.println(answer);
	}
}