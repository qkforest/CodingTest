import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		int[] dp = new int[sum];
		int idx = 1;
		dp[0] = Integer.parseInt(br.readLine());
		for(int i = 1; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int size =  s.length;
			for(int j = 0; j < size; j++) {
				if(j == 0) {
					dp[idx] = Integer.parseInt(s[j]) + dp[idx-size+1];
				}
				else if(j == size - 1) {
					dp[idx] = Integer.parseInt(s[j]) + dp[idx-size];
				}	
				else {
					dp[idx] = Integer.parseInt(s[j]) + Math.max(dp[idx-size+1], dp[idx-size]);
				}
				idx++;
			}
		}
		int answer = 0; 
		for(int i = dp.length-1; i > dp.length-1-n; i--) {
			answer = Math.max(answer, dp[i]);
		}
		System.out.println(answer);
	}
}