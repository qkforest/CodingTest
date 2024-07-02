import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][N];
		int INF = 101;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {;
				cost[i][j] = s[j].equals("0") ? INF : 1; 
			}
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				String str = cost[i][j] == INF ? "0" : "1";
				sb.append(String.valueOf(str)).append(" ");
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
		}
		System.out.print(sb.toString());
	}
}