import java.io.*;
import java.util.*;
class Main {
	public static char[][] map;
	public static boolean[][] visited;
	public static int R, C; 
	public static int answer = 0;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = c[j];
				if(map[i][j] == '@') {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		bfs();
		System.out.println(answer);
	}
	public static void bfs(){
		while(true) {
			int size = q.size();
			for(int i = 0; i < size; i++){
				int[] now = q.poll();
				for(int[] d : directions) {
					int y = now[0] + d[0];
					int x = now[1] + d[1];
					if(y >= 0 && y < R && x >= 0 && x < C && map[y][x] != '#' && !visited[y][x]) {
						if(map[y][x] == '&') {
							return;
						}
						visited[y][x] = true;
						q.offer(new int[] {y, x});
					} 
				}
			}
			if(size != 0) {
				answer++;
			} else {
				break;
			}
		}
		answer = -1;
	}
}