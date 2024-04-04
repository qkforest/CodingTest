import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] bridge = new int[len];
		int[] dp = new int[len];
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < len; i++) {
			bridge[i] = Integer.parseInt(str[i]);
			dp[i] = bridge[i];
		}
		for(int i = 3; i < len; i++){
			int min = Math.min(dp[i-3], dp[i-2]);
			min = Math.min(min, dp[i-1]);
			dp[i] = min + bridge[i];
		}
		int min = Math.min(dp[len-3], dp[len-2]);
		min = Math.min(min, dp[len-1]);
		System.out.println(min);
	}
}