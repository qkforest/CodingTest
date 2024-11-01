import java.io.*;
import java.util.*;

class Main {
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public static int[] comb;
	public static int answer;
	public static char[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for(int i = 0; i < 5; i++) {
			String str = br.readLine();
			for(int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		answer = 0;
		comb = new int[7];
		dfs(0, 0, 0);
		System.out.print(answer);
	}
	public static void dfs(int start, int cnt, int S) {
		if(cnt - S > 3) {
			return;
		}
		if(cnt == 7) {
			bfs(comb[0]/5, comb[0]%5);
			return;
		}
		for(int i = start; i < 25; i++) {
			int r = i / 5;
			int c = i % 5;
			comb[cnt] = i;
			dfs(i+1, cnt+1, (map[r][c] == 'S') ? S+1 : S);
		}
	}
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r, c});
		boolean[] visited = new boolean[7];
		visited[0] = true;
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int dr = now[0] + d[0];
				int dc = now[1] + d[1];
				if(dr < 0 || dr >= 5 || dc < 0 || dc >=5) {
					continue;
				}
				int n = dr * 5 + dc;
				for(int i = 1; i < 7; i++) {
					if(!visited[i] && comb[i] == n) {
						visited[i] = true;
						q.offer(new int[] {dr, dc});
						cnt++;
					}
				}
			}
		}
		if(cnt == 7) {
			answer++;
		}
	}
}