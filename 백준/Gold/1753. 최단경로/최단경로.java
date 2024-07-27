import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		int K = Integer.parseInt(br.readLine());
		List<int[]>[] cost = new ArrayList[V+1];
		boolean[] visited = new boolean[V+1];
		int[] answer = new int[V+1];
		for(int i = 0; i <= V; i++) {
			cost[i] = new ArrayList<int[]>();
			answer[i] = Integer.MAX_VALUE;
		}
		for(int i = 0; i < E; i++) {
			 s = br.readLine().split(" ");
			 cost[Integer.parseInt(s[0])].add(new int[] {Integer.parseInt(s[1]), Integer.parseInt(s[2])});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {K, 0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(!visited[now[0]]) {
				answer[now[0]] = now[1];
				for(int[] next: cost[now[0]]) {
					if(!visited[next[0]]) {
						pq.offer(new int[] {next[0], now[1]+next[1]});
					}
				}
			}
			visited[now[0]] = true;
		}
		answer[K] = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(answer[i] != Integer.MAX_VALUE) {
				sb.append(answer[i]);
			}
			else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}