import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Integer>[] friends = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			friends[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			friends[u].add(v);
			friends[v].add(u);
		}
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {1, 0});
		visited[1] = true;
		int answer = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[1] < 2) {
				for(int next : friends[now[0]]) {
					if(!visited[next]) {
						q.offer(new int[] {next, now[1]+1});
						visited[next] = true;
						answer++;
					}
				}
			}
		}
		System.out.print(answer);
	}
}