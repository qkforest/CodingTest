import java.util.*;
import java.io.*;

class Main {
	public static int N, answer, x, y, size, count;
	public static int[][] map;
	public static int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		x = 0;
		y = 0;
		size = 2;
		count = 0;
		answer = 0;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 9) {
					x = j;
					y = i;
				} else if(map[i][j] > 0) {
					count++;
				}
			}
		}
		if(count != 0) {
			map[y][x] = 0;
			count = 2;
			while(true) {
				if(bfs()) {
					break;
				}
			}
		}
		System.out.print(answer);
	}
	public static boolean bfs() {
		PriorityQueue<Box> pq = new PriorityQueue<>();
		pq.offer(new Box(y, x, 0));
		boolean[][] visited = new boolean[N][N];
		while(!pq.isEmpty()) {
			Box now = pq.poll();
			if(map[now.y][now.x] != 0 && map[now.y][now.x] < size) {
				map[now.y][now.x] = 0;
				answer += now.cost;
				y = now.y;
				x = now.x;
				count--;
				if(count == 0) {
					size++;
					count = size;
				}
				return false;
			}
			if(!visited[now.y][now.x]) {
				visited[now.y][now.x] = true;
				for(int[] d : directions) {
					int dy = now.y + d[0];
					int dx = now.x + d[1];
					if(dy >= 0 && dy < N && dx >= 0 && dx < N && map[now.y][now.x] <= size) {
						pq.offer(new Box(dy, dx,now.cost+1));
					}
				}
			}
		}
		return true;
	}
	public static class Box implements Comparable<Box> {
		int y;
		int x;
		int cost;
		
		public Box(int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		public int compareTo(Box other) {
			if(this.cost == other.cost) {
				if(this.y == other.y) {
					return this.x - other.x;
				}
				return this.y - other.y;
			}
			return this.cost - other.cost;
		}
	}
}