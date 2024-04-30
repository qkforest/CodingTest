import java.io.*;
import java.util.*;
public class Main {
	public static int N, M;
	public static boolean[] visited;
	public static Queue<int[]> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		q = new LinkedList<>();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			int temp =  Integer.parseInt(s[i]);
			q.offer(new int[] {temp, 0});
			visited[temp] = true;
		}
		System.out.println(bfs());
	}
	public static int bfs() {
		int score = 0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			score = Math.max(score, now[1]);
			for(int i = 0; i < 20; i++) {
				int next = now[0] ^ (1 << i);
				if(next <= N && !visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, now[1]+1});
				}
			}
		}
		return score;
	}
}