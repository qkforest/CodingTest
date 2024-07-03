import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] cost = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				cost[i][j] = 100;
				if(i == j) {
					cost[i][j] = 0;
				}
			}
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			cost[u][v] = 1;
			cost[v][u] = 1;
		}
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		int temp = Integer.MAX_VALUE;
		int answer = 1;
		for(int i = 1; i <= N; i++) {
			int sum = 0;
			for(int j = 1; j <= N; j++) {
				sum += cost[i][j];
			}
			
			if(temp > sum) {
				temp = sum;
				answer = i;
			}	
		}
		System.out.print(answer);
	}
}