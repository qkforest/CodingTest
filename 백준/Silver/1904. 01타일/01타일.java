import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[1000001];
		int N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 15746;
		}
		System.out.print(dp[N] % 15746);
	}
}