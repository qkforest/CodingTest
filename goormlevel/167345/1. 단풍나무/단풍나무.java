import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		Queue<int[]> q = new LinkedList<>();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] != 0) {
					q.offer(new int[] {i, j});
				}
			}
		}
		while(true){
			int size = q.size();
			if(size > 0) {
				answer++;
			}
			Queue<int[]> change = new LinkedList<>();
			for(int i = 0; i < size; i++) {
				int[] now = q.poll();
				int count = 0;
				for(int[] d : directions) {
					int y = now[0] + d[0];
					int x = now[1] + d[1];
					if(x >= 0 && x < N && y >= 0 && y < N && map[y][x] == 0){
						count++;
					}
				}
				change.offer(new int[] {now[0], now[1], Math.max(0, map[now[0]][now[1]]-count)});
			}
			while(!change.isEmpty()) {
				int[] c = change.poll();
				map[c[0]][c[1]] = c[2];
				if(c[2] > 0) {
					q.offer(new int[] {c[0], c[1]});
				}
			}
			if(q.isEmpty()){
				break;
			}
		}
		System.out.println(answer);
	}
}