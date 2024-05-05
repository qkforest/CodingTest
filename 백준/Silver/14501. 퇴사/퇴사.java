import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		int[] dp = new int[N+1];
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			T[i] = Integer.parseInt(s[0]);
			P[i] = Integer.parseInt(s[1]);
		}
		for(int i = 0; i < N; i++) {
			int day = i + T[i];
			if(day <= N) {
				dp[day] = Math.max(dp[day], dp[i] + P[i]);
			}
			dp[i+1] = Math.max(dp[i+1], dp[i]);
		}
		System.out.println(dp[N]);
	}
}