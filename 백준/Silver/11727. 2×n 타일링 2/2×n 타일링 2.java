import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		int MOD = 10007;
		dp[1] = 1;
		dp[2] = 3;
		for(int i = 3; i <= N; i++) {
			dp[i] =((dp[i-1] % MOD) + (2 * dp[i-2] % MOD)) % MOD;

		}
		System.out.println(dp[N]);
	}
}