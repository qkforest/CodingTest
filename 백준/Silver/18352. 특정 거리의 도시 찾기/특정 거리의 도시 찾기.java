import java.io.*;
import java.util.*;

class Main {
	public static int K, X;
	public static boolean[] visited;
	public static List<Integer>[] roads;
	public static Set<Integer> answer = new TreeSet<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		X = Integer.parseInt(s[3]);
		visited = new boolean[N+1];
		roads = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			roads[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			roads[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
		}
		
		bfs();
		
		StringBuilder sb = new StringBuilder();
		
		if(answer.size() == 0) {
			sb.append(-1);
		} else {
			for(int c : answer) {
				sb.append(c).append("\n");
			}
		}
		
		System.out.print(sb);
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {X, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(!visited[now[0]]) {
				if(now[1] == K) {
					answer.add(now[0]);
				}
				visited[now[0]] = true;
				for(int next : roads[now[0]]) {
					q.offer(new int[] {next, now[1]+1});
				}
			}
		}
	}
}