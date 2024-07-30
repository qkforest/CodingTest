import java.io.*;
import java.util.*;

class Main {
	public static List<Bridge>[] bridges;
	public static boolean[] visited;
	public static int start, dest;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		bridges = new ArrayList[N+1];
		visited = new boolean[N+1];
		for(int i = 0; i <= N; i++) {
			bridges[i] = new ArrayList<Bridge>();
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			bridges[A].add(new Bridge(B, C));
			bridges[B].add(new Bridge(A, C));
		}
		s = br.readLine().split(" ");
		start = Integer.parseInt(s[0]);
		dest = Integer.parseInt(s[1]);
		System.out.print(find());
	}
	public static int find() {
		int weight = Integer.MAX_VALUE;
		PriorityQueue<Bridge> pq = new PriorityQueue<>();
		pq.offer(new Bridge(start, Integer.MAX_VALUE));
		while(!pq.isEmpty()) {
			Bridge now = pq.poll();
			if(!visited[now.island]) {
				visited[now.island]= true;
				weight = Math.min(weight, now.weight);
				if(now.island == dest) {
					return weight;
				}
				for(Bridge next : bridges[now.island]) {
					pq.offer(new Bridge(next.island, next.weight));
				}
			}
		}
		return weight;
	}
	public static class Bridge implements Comparable<Bridge> {
		int island;
		int weight;
		
		public Bridge(int island, int weight) {
			this.island = island;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Bridge other) {
			return Integer.compare(other.weight, this.weight);
		}
	}
}