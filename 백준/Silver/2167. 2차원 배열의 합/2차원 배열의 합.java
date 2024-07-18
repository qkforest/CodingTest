import java.io.*;

class Main{
	public static long sum[][];
	public static long findSum(int i, int j, int x, int y) {
		long answer = 0;
		for(int start = i; start <= x; start++) {
			answer += sum[start][y]- sum[start][j-1];;
		}
		return answer;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		sum = new long[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			str = br.readLine().split(" ");
			sum[i][0] = sum[i-1][M];
			for(int j = 1; j <= M; j++) {
				sum[i][j] = sum[i][j-1] + Integer.parseInt(str[j-1]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < K; t++) {
			str = br.readLine().split(" ");
			int i = Integer.parseInt(str[0]);
			int j = Integer.parseInt(str[1]);
			int x = Integer.parseInt(str[2]);
			int y = Integer.parseInt(str[3]);
			sb.append(findSum(i, j, x, y)).append("\n");
		}
		System.out.print(sb);
	}
}