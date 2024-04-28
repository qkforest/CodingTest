import java.io.*;
import java.util.*;
public class Main {
	public static int M, N, count, days;
	public static int[][] box;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static Queue<int[]> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		box = new int[N][M];
		q = new LinkedList<>();
		count = 0;
		days = 0;
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(s[j]);
				if(box[i][j] == 0) {
					count++;
				}
				else if(box[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		if(count == 0) {
			System.out.println(0);
		}
		else {
			while(count > 0 && !q.isEmpty()) {
				int size = q.size();
				for(int i = 0; i < size; i++) {
					int[] now = q.poll();
					for(int[] d: directions) {
						int y = now[0] + d[0];
						int x = now[1] + d[1];
						if(y >=0 && y < N && x >=0 && x < M && box[y][x] == 0) {
							box[y][x] = 1;
							q.offer(new int[] {y, x});
							count--;
						}
					}
				}
				days++;
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