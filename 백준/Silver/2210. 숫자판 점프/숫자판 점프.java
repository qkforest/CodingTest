import java.io.*;
import java.util.*;
class Main {
	public static String[][] board;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static Set<String> set;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new String[5][5];
		set = new HashSet<>();
		for(int i = 0; i < 5; i++) {
			board[i] = br.readLine().split(" ");
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				bfs(i, j);
			}
		}
		System.out.print(set.size());
	}
	public static void bfs(int i, int j) {
		Queue<Square> q = new LinkedList<>();
		q.offer(new Square(i, j, 1, board[i][j]));
		while(!q.isEmpty()) {
			Square now = q.poll();
			if(now.length == 6) {
				set.add(now.s);
				continue;
			}
			for(int[] d : directions) {
				int y = now.y + d[0];
				int x = now.x + d[1];
				if(y >= 0 && y < 5 && x >= 0  && x < 5) {
					q.offer(new Square(y, x, now.length+1, new StringBuilder(now.s).append(board[y][x]).toString()));
				}
			}
		}
	}
	static class Square {
		int y;
		int x;
		int length;
		String s;
		
		public Square(int y, int x, int length, String s) {
			this.y = y;
			this.x = x;
			this.length = length;
			this.s = s;
		}
	}
}