import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int C = Integer.parseInt(s[1]);
		int M = Integer.parseInt(br.readLine());
		int[][] delivery = new int[M][3];
		
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			delivery[i][0] = Integer.parseInt(s[0]);
			delivery[i][1] = Integer.parseInt(s[1]);
			delivery[i][2] = Integer.parseInt(s[2]);
		}
		
		Arrays.sort(delivery, (a, b) -> {
			if(a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, C);
		int answer = 0;
		
		for(int i = 0; i < M; i++) {
			int b = delivery[i][0];
			int e = delivery[i][1];
			int box = delivery[i][2];
			
			int count = Integer.MAX_VALUE;
			
			for(int j = b; j < e; j++) {
				count = Math.min(count, dp[j]);
			}
			
			for(int j = b; j < e; j++) {
				dp[j] -= Math.min(count, box);
			}
			
			answer += Math.min(count,  box);
		}
		
		System.out.println(answer);
 	}
}