import java.io.*;
import java.util.*;


class Main {
	public static int R, C, T;
	public static int[] air;
	public static int[][] board;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static Queue<Dust> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		T = Integer.parseInt(s[2]);
		board = new int[R][C];
		air = new int[2];
		Arrays.fill(air, -1);
		q = new LinkedList<>();
		for(int i = 0; i < R; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < C; j++) {
				int v = Integer.parseInt(s[j]);
				board[i][j] = v;
				if(v == -1) {
					if(air[0] == -1) {
						air[0] = i;
					} else {
						air[1] = i;
					}
				}
				else if(v > 0) {
					q.offer(new Dust(i, j));
				}
			}
		}
		for(int i = 0; i < T; i++) {
			diffusion();
		}
		long answer = 0;
		while(!q.isEmpty()) {
			Dust now = q.poll();
			answer += board[now.y][now.x];
		}
		System.out.print(answer);
	}
	
	public static void diffusion() {
		Map<Dust, Integer> map = new HashMap<>();
		while(!q.isEmpty()) {
			Dust now = q.poll();
			int amount = board[now.y][now.x];
			int diff_amount = (int) Math.floor(amount/5);
			int count = 0;
			for(int[] d : directions) {
				int dy = now.y + d[0];
				int dx = now.x + d[1];
				if(dy >= 0 && dy < R && dx >= 0 && dx < C && board[dy][dx] != -1) {
					count++;
					Dust next = new Dust(dy ,dx);
					if(map.containsKey(next)) {
						int value = map.get(next) + diff_amount;
						map.put(next, value);
					} else {
						map.put(next, diff_amount);
					}
				}
			}
			if(map.containsKey(now)) {
				int value = map.get(now) + (diff_amount * count * (-1));
				map.put(now, value);
			} else {
				map.put(now, diff_amount * count * (-1));
			}
		}
		for(Dust now : map.keySet()) {
			int amount = map.get(now);
			board[now.y][now.x] += amount;
		}
		top();
		bottom();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(board[i][j] > 0) {
					q.offer(new Dust(i, j));
				}
			}
		}
	}
	
	public static void top() {
		Queue<Integer> next = new LinkedList<>();
		next.offer(0);
		int y = air[0];
		int x = 1;
		while(y != air[0] || x != 0) {
			next.offer(board[y][x]);
			board[y][x] = next.poll();
			if(y == 0) {
				if(x > 0) {
					x--;
				} else {
					y++;
				}
			}
			else if(y == air[0]) {
				if(x < C-1) {
					x++;
				} else {
					y--;
				}
			}
			else if(x == C-1) {
				if(y > 0) {
					y--;
				} else {
					x--;
				}
			} 
			else {
				y++;
			}
		}
	}
	
	public static void bottom() {
		Queue<Integer> next = new LinkedList<>();
		next.offer(0);
		int y = air[1];
		int x = 1;
		while(y != air[1] || x != 0) {
			next.offer(board[y][x]);
			board[y][x] = next.poll();
			if(y == R-1) {
				if(x > 0) {
					x--;
				} else {
					y--;
				}
			}
			else if(y == air[1]) {
				if(x < C-1) {
					x++;
				} else {
					y++;
				}
			}
			else if(x == C-1) {
				if(y < R-1) {
					y++;
				} else {
					x--;
				}
			} 
			else {
				y--;
			}
		}
	}
	
	public static class Dust {
		int y;
		int x;
		
		public Dust(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this == o) {
				return true;
			}
			
			if(o == null || getClass() != o.getClass()) {
				return false;
			}
			
			Dust other = (Dust) o;
			return y == other.y && x == other.x;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(y, x);
		}
	}
}