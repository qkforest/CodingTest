import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 1;
		for(int i = 5; i <= n; i++) {
			int sum = dp[i-4] + dp[i-3] + dp[i-1];
			if(sum != 3) {
				dp[i] = 1;
			}
		}
		if(dp[n] == 1){
			System.out.print("SK");
		}
		else {
			System.out.print("CY");
		}
	}
}