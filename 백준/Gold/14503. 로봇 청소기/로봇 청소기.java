import java.io.*;
import java.util.*;

class Main {
	public static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	public static int[] rotate = {3, 0, 1, 2};
	public static int count, N, M;
	public static int[][] map;
	public static boolean active;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		map = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		s = br.readLine().split(" ");
		int y = Integer.parseInt(s[0]);
		int x = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		active = true;
		clean(y, x, d);
		System.out.print(count);
	}
	public static void clean(int y, int x, int d) {
		boolean available = false;
		if(map[y][x] == 0) {
			count++;
			map[y][x] = 2;
		}
		
		for(int i = 0; i < 4; i++) {
			d = rotate[d];
			int nextY = y + directions[d][0];
			int nextX = x + directions[d][1];
			if(map[nextY][nextX] == 0) {
				available = true;
				clean(nextY, nextX, d);
				if(!active) {
					return;
				}
			}
		}
		if(!available) {
			int back = (d + 2) % 4;
			int nextY = y + directions[back][0];
			int nextX = x + directions[back][1];
			if(map[nextY][nextX] != 1) {
				clean(nextY, nextX, d);
			} else {
				active = false;
			}
		}
	}
}