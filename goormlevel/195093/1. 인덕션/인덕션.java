import java.io.*;
import java.util.*;
class Main {
	public static int N;
	public static int[] temps;
	public static int[][] counts;
	public static int[][][][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		temps = new int[N+1];
		for(int i = 1; i <= N; i++) {
			temps[i] = Integer.parseInt(s[i-1]);
		}
		dp = new int[N+1][10][10][10];
		for(int[][][] first: dp){
			for(int[][] second : first) {
				for(int[] third : second) {
					Arrays.fill(third, -1);
				}
			}
		}
		counts = new int[10][10];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				int diff = Math.abs(i - j);
				counts[i][j] = Math.min(diff, 10 - diff);
			}
		}
		System.out.println(count(0, 0, 0, 0));
	}
	public static int count(int i, int f, int s, int t){ 
		int c;
		if(i == N) {
			return 0;
		}
		int temp = temps[i+1];
		if(dp[i][f][s][t] == -1) {
			dp[i][f][s][t] = Integer.MAX_VALUE;
			c = count(i+1, temp, s, t) + counts[f][temp];
			if(dp[i][f][s][t] > c) {
				dp[i][f][s][t] = c;
			}
			c = count(i+1, f, temp, t) + counts[s][temp];
			if(dp[i][f][s][t] > c) {
				dp[i][f][s][t] = c;
			}
			c = count(i+1, f, s, temp) + counts[t][temp];
			if(dp[i][f][s][t] > c) {
				dp[i][f][s][t] = c;
			}
		}
		return dp[i][f][s][t];
	}
}