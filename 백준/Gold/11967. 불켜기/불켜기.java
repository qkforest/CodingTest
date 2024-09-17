import java.io.*;
import java.util.*;

class Main {
	public static int N;
	public static List<Pos>[][] switches;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		switches = new ArrayList[N+1][N+1];
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			Pos room = new Pos(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
			if(switches[x][y] == null) {
				switches[x][y] = new ArrayList<>();
			}
			switches[x][y].add(room);
			
		}
		System.out.print(bfs());
	}
	public static int bfs() {
		boolean[][] visited = new boolean[N+1][N+1];
		boolean[][] lights = new boolean[N+1][N+1];
		Queue<Pos> q = new LinkedList<>();
		
		int count = 1;
		q.offer(new Pos(1,1));
		lights[1][1] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			int x = now.x;
			int y = now.y;
			if(switches[x][y] != null) {
				for(Pos next : switches[x][y]) {
					if(!lights[next.x][next.y]) {
						if(visited[next.x][next.y]) {
							q.offer(new Pos(next.x, next.y));
						}
						lights[next.x][next.y] = true;
						count++;
					}
				}
			}
			for(int i = 0; i < 4 ; i++) {
				int dx = x + directions[i][0];
				int dy = y + directions[i][1];
				if(dx > 0 && dx <= N && dy > 0 && dy <= N &&!visited[dx][dy]) {
					visited[dx][dy] = true;
					if(lights[dx][dy]) {
						q.offer(new Pos(dx, dy));
					}
				}
			}
		}
		
		return count;
		
	}
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}