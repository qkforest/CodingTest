import java.io.*;
import java.util.*;

class Main {
	public static int[][][] map;
	public static int answer;
	public static int[] order;
	public static boolean[] v;
	public static int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5][5];
		order = new int[5];
		answer = Integer.MAX_VALUE;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();	
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				rotate(i);
				v = new boolean[5];
				order(0);
			}
		}
		search(0);
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.print(answer);
	}
	public static void search(int idx) {
		if(idx == 5) {
			v = new boolean[5];
			order(0);
			return;
		}
		for(int i = 0 ; i < 4; i++) {
			rotate(idx);
			search(idx+1);
		}
	}
	public static void rotate(int idx) {
		int[][] rotate = new int[5][5];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				rotate[i][j] = map[idx][4-j][i];	
			}
			
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				map[idx][i][j] = rotate[i][j];	
			}
		}
	}
	public static void order(int level) {
		if(level == 5) {
			bfs();
			return;
		}
		for(int i = 0; i < 5; i++) {
			if(!v[i]) {
				v[i] = true;
				order[level] = i;
				order(level+1);
				v[i] = false;
			}
		}
	}
	public static void bfs() {
		if(map[order[0]][0][0] == 0 || map[order[4]][4][4] == 0) {
			return;
		}
		boolean[][][] visited = new boolean[5][5][5];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0, 0, 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int h = now[0];
			int r = now[1];
			int c = now[2];
			if(h == 4 && r == 4 && c == 4) {
				answer = Math.min(answer, now[3]);
			}
			if(!visited[h][r][c]) {
				visited[h][r][c] = true;
				for(int[] d : directions) {
					int dh = h + d[0];
					int dr = r + d[1];
					int dc = c + d[2];
					if(dh >= 0 && dh < 5 && dr >= 0 && dr < 5 && dc >= 0 && dc < 5 && map[order[dh]][dr][dc] == 1) {
						q.offer(new int[] {dh, dr, dc, now[3]+1});
					}
				}
			}
		}
	}
}