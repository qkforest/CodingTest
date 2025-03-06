import java.io.*;
class Main {
	public static char[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		star(0, 0, N, false);
		for(int i = 0; i < N; i++) {
			sb.append(String.valueOf(map[i])).append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
	public static void star(int y, int x, int N, boolean blank) {
		if(blank) {
			for(int i = y; i < y+N; i++) {
				for(int j = x; j < x+N; j++) {
					map[i][j] = ' ';
				}
			}
			return;
		}
		if(N == 1) {
			map[y][x] = '*';
			return;
		}
		int size = N / 3;
		int part = 1;
		for(int i = y; i < y+N; i+=size) {
			for(int j = x; j < x+N; j+=size) {
				if(part == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
				part++;
			}
		}
	}
}