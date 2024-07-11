import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<int[]>[] map = new ArrayList[n+1];
		boolean[] visited = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			map[i] = new ArrayList<>();
		}
		for(int i = 0; i < m ; i++) {
			String[] s = br.readLine().split(" ");
			map[Integer.parseInt(s[0])].add(new int[] {Integer.parseInt(s[1]), Integer.parseInt(s[2])});
		}
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int des = Integer.parseInt(s[1]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {start, 0});
		int answer = 0;
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			if(!visited[now[0]]) {
				visited[now[0]] = true;
				if(now[0] == des) {
					answer = now[1];
					break;
				}
				for(int[] next : map[now[0]]) {
					pq.offer(new int[] {next[0], now[1] + next[1]});
				}
			}
		}
		System.out.print(answer);
	}
}