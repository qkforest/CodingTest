import java.io.*;
import java.util.*;
class Main {
	public static int N, M;
	public static int[][] map;
	public static boolean[][] visited;
	public static int answer;
	public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		answer = 0;
		for(int i = 0; i < N; i++){
			s = br.readLine().split(" ");
			for(int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] != 1) {
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}
	public static void bfs(int i, int j){
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		visited[i][j] = true;
		int temp = 0;
		while(!q.isEmpty()){
			int[] now =  q.poll();
			temp += score(now);
			for(int[] d: directions){
				int y = now[0] + d[0];
				int x = now[1] + d[1];
				if(y >= 0 && y < N && x >= 0 && x < M && !visited[y][x] && map[y][x] != 1){
					visited[y][x] = true;
					q.offer(new int[] {y, x});
				}
			}
		}
		answer = Math.max(answer, temp);
	}
	public static int score(int[] pos){
		if(map[pos[0]][pos[1]] == 0){
			return 1;
		}
		else if(map[pos[0]][pos[1]] == 2){
			return -2;
		}
		else{
			return 0;
		}
	}
}