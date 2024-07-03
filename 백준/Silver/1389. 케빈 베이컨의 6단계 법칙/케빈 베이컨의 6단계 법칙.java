import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[][] cost = new int[N][N];
		int answer = 0;
		int sum = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			Arrays.fill(cost[i], 100);
			cost[i][i] = 0;
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]) - 1;
			int v = Integer.parseInt(s[1]) - 1;
			cost[u][v] = 1;
			cost[v][u] = 1;
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		for(int i = 0; i < N; i++) {
			int temp = IntStream.of(cost[i]).sum();
			if(temp < sum) {
				sum = temp;
				answer = i+1;
			}
		}
		System.out.print(answer);
	}
}