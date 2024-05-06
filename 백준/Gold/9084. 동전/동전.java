import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] answer = new int[T];
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				coins[j] = Integer.parseInt(s[j]);
			}
			int money = Integer.parseInt(br.readLine());
			int[] dp = new int[money+1];
			for(int j = 0; j < N; j++) {
				for(int k = 1; k <= money; k++) {
					if(k - coins[j] > 0) {
						dp[k] = dp[k] + dp[k-coins[j]];
					} else if(k - coins[j] == 0){
						dp[k]++;
					}
				}
			}
			answer[i] = dp[money]; 
		}
		for(int ans : answer) {
			System.out.println(ans);
		}
	}
}