import java.io.*;
import java.util.*;

class Main {
	public static int[][] map;
	public static boolean[][] visited;
	public static int n;
	public static int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] rooms = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) {
				map[i][j] = rooms[j] - '0';
			}
		}
		
		System.out.print(bfs());
	}
	
	public static int bfs() {
		PriorityQueue<Room> pq = new PriorityQueue<>();
		pq.offer(new Room(0, 0 ,0));
		
		while(!pq.isEmpty()) {
			Room now = pq.poll();
			
			if(now.y == n-1 && now.x == n-1) {
				return now.change; 
			}
			
			while(!visited[now.y][now.x]) {
				visited[now.y][now.x] = true;
				
				for(int[] d  : directions) {
					int y = now.y + d[0];
					int x = now.x + d[1];
					
					if(y >= 0 && y < n && x >= 0 && x < n) {
						if(map[y][x] == 1) {
							pq.offer(new Room(y, x , now.change));
						} else {
							pq.offer(new Room(y, x , now.change+1));
						}
					}
				}
			}
		}
		
		return 0;
	}
	
	public static class Room implements Comparable<Room> {
		int y;
		int x;
		int change;
		
		public Room(int y, int x, int change) {
			this.y = y;
			this.x = x;
			this.change = change;
		}
		
		@Override
		public int compareTo(Room other) {
			return this.change - other.change;
		}
	}
}