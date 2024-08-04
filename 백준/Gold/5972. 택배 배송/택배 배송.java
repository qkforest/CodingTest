import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		boolean[] visited = new boolean[N+1];
		List<int[]>[] costs = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			costs[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			int C = Integer.parseInt(s[2]);
			costs[A].add(new int[] {B, C});
			costs[B].add(new int[] {A, C});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] {1 , 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(now[0] == N) {
				System.out.print(now[1]);
				break;
			}
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				for(int[] next : costs[now[0]]) {
					pq.offer(new int[] {next[0], next[1] + now[1]});
				}
			}
		}
	}
}