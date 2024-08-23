import java.util.*;
import java.io.*;

class Main {
	public static int N, answer, INF;
	public static List<Node>[] graph;
	public static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		INF = 200000000;
		int E = Integer.parseInt(s[1]);
		
		graph = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			graph[u].add(new Node(v, c));
			graph[v].add(new Node(u, c));
		}
		
		s = br.readLine().split(" ");
		
		
		int first = Integer.parseInt(s[0]);
		int second = Integer.parseInt(s[1]);
		
		int result1 = dijkstra(1, first);
		result1 += dijkstra(first, second);
		result1 += dijkstra(second, N);
		
		int result2 = dijkstra(1, second);
		result2 += dijkstra(second, first);
		result2 += dijkstra(first, N);
		
		long answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
		
		System.out.print(answer);
		
	}
	
	public static int dijkstra(int start, int destination) {
		visited = new boolean[N+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.idx == destination) {
				return now.cost;
			}
			if(!visited[now.idx]) {
				visited[now.idx] = true;
				for(Node next : graph[now.idx]) {
					pq.offer(new Node(next.idx, now.cost+next.cost));
				}
			}
		}
		return INF;
	}
	
	static class Node implements Comparable<Node> {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		public int compareTo(Node other) {
			return this.cost - other.cost;
		}
	}
}