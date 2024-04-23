import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static int[] start = new int[3];
	public static int[] dest = new int[2];
	public static int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {2, -1}, {1, -2}, {2, 1}, {1, 2}};
	public static boolean[][] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N][N];
			String[] s = br.readLine().split(" ");
			start[0] = Integer.parseInt(s[0]);
			start[1] = Integer.parseInt(s[1]);
			s = br.readLine().split(" ");
			dest[0] = Integer.parseInt(s[0]);
			dest[1] = Integer.parseInt(s[1]);
			if(start[0] == dest[0] && start[1] == dest[1]) {
				System.out.println(0);
			}
			else {
				System.out.println(bfs());
			}
		}
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(start);
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == dest[0] && now[1] == dest[1]) {
				return now[2];
			}
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 &&  y < N && x >= 0 &&  x < N && !visited[y][x]) {
					visited[y][x] = true;
					q.offer(new int[] {y, x, now[2]+1});
				}
			}
		}
		return 0;
	}
}