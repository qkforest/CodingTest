import java.io.*;
import java.util.*;

class Main {
	public static int N , M, answer;
	public static boolean[] visited;
	public static List<Integer>[] connected;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt( br.readLine());
		visited = new boolean[N+1];
		connected = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			connected[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			connected[u].add(v);
			connected[v].add(u);
		}
		
		answer = 0;
		
		bfs();
		
		System.out.print(answer-1);
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(!visited[now]) {
				visited[now] = true;
				answer++;
				for(int next : connected[now]) {
					q.offer(next);
				}
			}
		}
	}
}