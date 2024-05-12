import java.io.*;
import java.util.Arrays;
public class Main {
	public static int N, K, answer;
	public static int[][] cost;
	public static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		cost = new int[N][N];
		for(int i = 0; i < N; i++) {
			cost[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N ; i++) {
				for(int j = 0; j < N; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];
		visited[K] = true;
		dfs(1, K, 0);
		System.out.println(answer);
	}
	public static void dfs(int cnt, int s, int time) {
		if(cnt == N) {
			answer = Math.min(answer, time);
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(cnt+1, i, time+cost[s][i]);
				visited[i] = false;
			}
		}
	}
}