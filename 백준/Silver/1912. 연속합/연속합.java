import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] dp = new int[N];
		dp[0] = Integer.parseInt(s[0]);
		long answer = dp[0];
		for(int i = 1; i < N; i++) {
			int a = Integer.parseInt(s[i]);
			dp[i] = Math.max(dp[i-1]+a, a); 
			answer = Math.max(answer, dp[i]);
		}
		System.out.print(answer);
	}
}