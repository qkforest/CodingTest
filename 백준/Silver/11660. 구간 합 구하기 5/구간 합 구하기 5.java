import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] arr = new int[N][N+1];
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(s[j-1]);
			}
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			long answer = 0;
			int x1 = Integer.parseInt(s[0]) - 1;
			int y1 = Integer.parseInt(s[1]) - 1;
			int x2 = Integer.parseInt(s[2]) - 1;
			int y2 = Integer.parseInt(s[3]);
			for(int j = x1; j <= x2; j++) {
				answer += arr[j][y2] - arr[j][y1];
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}