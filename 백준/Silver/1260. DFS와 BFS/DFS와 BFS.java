import java.io.*;
import java.util.*;

class Main {
	public static int V;
	public static Set<Integer>[] graph;
	public static boolean[] visited;
	public static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		V = Integer.parseInt(s[2]);
		graph = new TreeSet[N+1];
		visited = new boolean[N+1];
		for(int i = 1 ; i <= N; i++) {
			graph[i] = new TreeSet<>();
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			graph[u].add(v);
			graph[v].add(u);
		}
		sb = new StringBuilder();
		sb.append(V).append(" ");
		visited[V] = true;
		dfs(V);
		System.out.println(sb.deleteCharAt(sb.length()-1).toString());
		visited = new boolean[N+1];
		sb = new StringBuilder();
		bfs();
	}
	public static void dfs(int now) {
		for(int next : graph[now]) {
			if(!visited[next]) {
				visited[next] = true;
				sb.append(next).append(" ");
				dfs(next);
			}
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(V);
		visited[V] = true;
		StringBuilder sb = new StringBuilder();
		sb.append(V).append(" ");
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph[now]) {
				if(!visited[next]) {
					visited[next] = true;
					sb.append(next).append(" ");
					q.offer(next);
				}
			}
		}
		System.out.print(sb.deleteCharAt(sb.length()-1).toString());
	}
}