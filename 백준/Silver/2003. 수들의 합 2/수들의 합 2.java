import java.io.*;
class Main{
	public static int N, M;
	public static int[] parents;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int answer = 0;
		s = br.readLine().split(" ");
		long[] dp = new long[N];
		dp[0] = Long.parseLong(s[0]);
		for(int i = 1; i < N; i++) {
			dp[i] =  dp[i-1] + Long.parseLong(s[i]);
		}
		for(int j = 0; j < N; j++) {
			int left = 0;
			int right = j;
			while(left <= right) {
				int mid = (left + right) / 2;
				long sum = dp[j] - dp[mid] +  Long.parseLong(s[mid]);
				if(sum == M) {
					answer++;
					break;
				}
				else if(sum  > M) {
					left = mid +1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		System.out.println(answer);
	}
}