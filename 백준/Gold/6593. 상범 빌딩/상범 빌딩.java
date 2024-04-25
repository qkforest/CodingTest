import java.io.*;
import java.util.*;
public class Main {
	public static int L, R, C;
	public static char[][][] map;
	public static boolean[][][] visited;
	public static int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}}; 
	public static int[] start, end;
	public static List<String> answer;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		answer = new ArrayList<>();
		while(true) {
			String[] s = br.readLine().split(" ");
			L = Integer.parseInt(s[0]);
			R = Integer.parseInt(s[1]);
			C = Integer.parseInt(s[2]);
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			start = new int[3];
			end = new int[3];
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					String str = br.readLine();
					for(int k = 0; k < C; k++) {
						map[i][j][k] = str.charAt(k);
						if(map[i][j][k] == 'S') {
							start[0] = i;
							start[1] = j;
							start[2] = k;
							visited[i][j][k] = true;
						}
						else if(map[i][j][k] == 'E') {
							end[0] = i;
							end[1] = j;
							end[2] = k;
						}
					}
				}
				br.readLine();
			}
			answer.add(bfs());
		}
		for(String ans: answer) {
			System.out.println(ans);
		}
	}
	public static String bfs() {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {start[0], start[1], start[2], 0});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == end[0] && now[1] == end[1] && now[2] == end[2]) {
				return "Escaped in " + String.valueOf(now[3]) + " minute(s).";
			}
			for(int[] d : directions) {
				int l = now[0] + d[0];
				int y = now[1] + d[1];
				int x = now[2] + d[2];
				if(l >= 0 && l < L && y >= 0 && y < R && x >= 0 && x < C && !visited[l][y][x] && map[l][y][x] != '#') {
					visited[l][y][x] = true;
					q.offer(new int[] {l, y, x, now[3]+1});
				}
			}
		}
		return "Trapped!";
	}
}