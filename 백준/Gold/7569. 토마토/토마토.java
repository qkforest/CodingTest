import java.io.*;
import java.util.*;
public class Main {
	public static int M, N, H, count;
	public static char[][][] box;
	public static Queue<int[]> q;
	public static int[][] directions = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]);
		box = new char[H][N][M];
		q = new LinkedList<>();
		count = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				String[] c = br.readLine().split(" ");
				for(int k = 0; k < M; k++) {
					box[i][j][k] = c[k].charAt(0);
					if(box[i][j][k] == '0') {
						count++;
					}
					else if(box[i][j][k] == '1') {
						q.offer(new int[] {i, j , k});
					}
				}
			}
		}
		if(count == 0) {
			System.out.println(0);
		}
		else {
			int days = 0;
			while(true) {
				int size = q.size();
				if(size == 0) {
					break;
				}
				for(int i = 0; i < size; i++) {
					int[] now = q.poll();
					for(int[] d : directions) {
						int h = now[0] + d[0];
						int y = now[1] + d[1];
						int x = now[2] + d[2];
						if(h >= 0 && h < H && y >= 0 && y < N && x >= 0 && x < M && box[h][y][x] == '0') {
							box[h][y][x] = '1';
							q.offer(new int[] {h, y, x});
							count--;
						}
					}
				}
				days++;
				if(count == 0) {
					break;
				}
			}
			if(count == 0) {
				System.out.println(days);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}