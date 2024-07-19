import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1001];
		for(int i = 1; i <= 1000; i++) {
			dp[i] = 1; 
			for(int j = 0; j < i; j++) {
				if (((i - j) / 2) * 2 + j == i) {
					dp[i] += dp[(i - j) / 2];
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.print(sb);
	}
}