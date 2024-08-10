import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		boolean[] visited = new boolean[100001];
		
		PriorityQueue<Pos> q = new PriorityQueue<>();
		q.offer(new Pos(N, 0) );
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.x == K) {
				System.out.print(now.time);
				break;
			}
			if(!visited[now.x]) {
				visited[now.x] = true;
				for(int i = 0; i < 3; i++) {
					int next;
					int time = now.time + 1;
					if(i == 0) {
						next = now.x - 1;
					} else if(i == 2) {
						next = now.x + 1;
					} else {
						next = 2 * now.x;
						time--;
					}
					if(next >= 0 && next <= 100000) {
						q.offer(new Pos(next, time));
					}
				}
			}
		}
	}
	
	public static class Pos implements Comparable<Pos>{
		int x;
		int time;
		
		public Pos(int x, int time) {
			this.x = x;
			this.time = time;
		}
		
		@Override
		public int compareTo(Pos other) {
			return this.time - other.time;
		}
	}
}