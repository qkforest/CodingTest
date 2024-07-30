import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		System.out.print(bfs(N, K));
	}
	public static int bfs(int N, int K) {
		Queue<Pos> q = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		q.offer(new Pos(N, 0));
		int[] directions = {1, -1, 2};
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(now.point == K) {
				return now.time;
			}
			if(!visited[now.point]) {
				visited[now.point] = true;
				int next;
				for(int d : directions) {
					if(d == 2) {
						next = now.point * 2;
					} else {
						next = now.point + d;
					}
					if(next >= 0 && next < 100001) {
						q.offer(new Pos(next, now.time+1));
					}
				}
			}
		}
		return 0;
	}
	static class Pos {
		int point;
		int time;
		public Pos(int point, int time) {
			this.point = point;
			this.time = time;
		}
	}
}