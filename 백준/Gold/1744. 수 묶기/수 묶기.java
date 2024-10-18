import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dp = new int[N][2];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		if(N == 1) {
			answer = arr[0];
		} else {
			Arrays.sort(arr);
			dp[0][0] = arr[0];
			dp[0][1] = arr[0];
			dp[1][0] = arr[0] + arr[1];
			dp[1][1] = arr[0] * arr[1];
			for(int i = 2; i < N; i++) {
				int a = Math.max(dp[i-1][0], dp[i-1][1]);
				dp[i][0] = a + arr[i];
				a = Math.max(dp[i-2][0], dp[i-2][1]);
				dp[i][1] = arr[i] * arr[i-1] + a;
			}
			answer = Math.max(dp[N-1][0], dp[N-1][1]);
		}
		
		System.out.print(answer);
	}
}