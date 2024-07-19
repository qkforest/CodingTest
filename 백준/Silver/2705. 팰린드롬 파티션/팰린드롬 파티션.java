import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[1001];
		
		// 문제에서 N은 1000보다 작거나 같다고 했으므로 1부터 1000까지 각 수의  팰린드롬 파티션 개수를 구한다.
		for(int N = 1; N <= 1000; N++) {
			dp[N] = 1; // 자기 자신
			/**
			 * i는 팰린드롬 파티션에서 가운데 오는 수
			 * 0부터 N-1까지 올 수 있다
			 */
			for(int i = 0; i < N; i++) {
				/** 가운데 수가 i일 때, 팰린드롬 파티션의 수는 (N-i)/2의 팰린드롬 파티션 개수와 동일하다.
				 * 가운데를 기준으로 양 옆도 항상 팰린드롬 파티션을 가져야 하기 때문이다.
				 */
				if ((N - i) % 2 == 0) {
					dp[N] += dp[(N - i) / 2];
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