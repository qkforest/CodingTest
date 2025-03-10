import java.util.*;
import java.io.*;
class Main {
	public static int[][] board;
	public static List<int[]> list;
	public static int size;
	public static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		board = new int[9][9];
		list = new ArrayList<>();
		for(int i = 0; i < 9; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(s[j]);
				if(s[j].equals("0")) {
					list.add(new int[] {i, j});
				}
			}
		}
		size = list.size();
		fill(0);
		System.out.print(sb);
	}
	public static void fill(int cnt) {
		if(sb.length() > 0) {
			return;
		}
		if(cnt == size) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		int y = list.get(cnt)[0];
		int x = list.get(cnt)[1];
		for(int n = 1; n <= 9; n++) {
			if(check(y, x, n)) {
				board[y][x] = n;
				fill(cnt+1);
				board[y][x] = 0;
			}
		}
	}
	public static boolean check(int y, int x, int n) {
		for(int i = 0; i < 9; i++) {
			if(i == y) {
				continue;
			}
			if(board[i][x] == n) {
				return false;
			}
		}
		for(int i = 0; i < 9; i++) {
			if(i == x) {
				continue;
			}
			if(board[y][i] == n) {
				return false;
			}
		}
		int a = (y/3) * 3;
		int b = (x/3) * 3;
		for(int i = a; i < a+3; i++) {
			for(int j = b; j < b+3; j++) {
				if(i == y && j == x) {
					continue;
				}
				if(board[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}
}