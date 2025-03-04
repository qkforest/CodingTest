import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		long[][] arr = new long[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			s = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				arr[i][j] = arr[i][j-1] + arr[i-1][j] + Integer.parseInt(s[j-1]) - arr[i-1][j-1];
			}
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);
			sb.append(arr[x2][y2]-arr[x2][y1-1]-arr[x1-1][y2]+arr[x1-1][y1-1]).append("\n");
		}
		System.out.print(sb);
	}
}