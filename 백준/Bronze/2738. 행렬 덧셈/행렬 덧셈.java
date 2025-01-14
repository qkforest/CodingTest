import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] A = new int[N][M];
		for(int k = 0; k < 2; k++) {
			for(int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for(int j = 0; j < M; j++) {
					A[i][j] += Integer.parseInt(s[j]);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}