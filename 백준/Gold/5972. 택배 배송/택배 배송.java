import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		boolean[] visited = new boolean[N+1];
		List<Hut>[] costs = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			costs[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			costs[A].add(new Hut(B, C));
			costs[B].add(new Hut(A, C));
		}
		
		PriorityQueue<Hut> pq = new PriorityQueue<>();
		pq.offer(new Hut(1 , 0));
		
		while(!pq.isEmpty()) {
			Hut now = pq.poll();
			if(now.n == N) {
				System.out.print(now.cost);
				break;
			}
			if(!visited[now.n]) {
				visited[now.n] = true;
				for(Hut next : costs[now.n]) {
					pq.offer(new Hut(next.n, next.cost + now.cost));
				}
			}
		}
	}
	
	public static class Hut implements Comparable<Hut> {
		int n;
		int cost;
		
		public Hut(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Hut other) {
			return this.cost - other.cost;
		}
	}
}