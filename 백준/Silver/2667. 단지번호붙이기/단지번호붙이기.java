import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static char[][] map;
	public static boolean[][] visited;
	public static List<Integer> answer;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		answer = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			map[i]= br.readLine().toCharArray();
		}
		//System.out.println(Arrays.deepToString(map));
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '1' && !visited[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int n : answer) {
			System.out.println(n);
		}
	}
	public static void bfs(int i, int j) {
		int size = 1;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int[] d : directions) {
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if((y >= 0 && y < N && x >=0 && x < N && !visited[y][x]) && map[y][x] == '1') {
					visited[y][x] = true;
					q.offer(new int[] {y, x});
					size++;
				}
			}
		}
		answer.add(size);
	}
}