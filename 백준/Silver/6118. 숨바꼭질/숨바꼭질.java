import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] cost = new int[N+1];
		List<Integer>[] map = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			map[u].add(v);
			map[v].add(u);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : map[now]) {
				if(!visited[next]) {
					cost[next] = cost[now]+1;
					q.add(next);
					visited[next] = true;
				}
			}
		}
		int idx = 0;
		int num = 0;
		for(int i = 1; i <= N; i++) {
			if(cost[i] > cost[idx]) {
				idx = i;
				num = 1;
			}
			else if(cost[i] == cost[idx]) {
				num++;
			}
		}
		System.out.println(idx + " " + cost[idx] + " " + num);
	}
}