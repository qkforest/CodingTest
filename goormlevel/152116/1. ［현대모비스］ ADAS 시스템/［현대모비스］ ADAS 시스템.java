import java.io.*;
import java.util.*;
class Main {
	public static int W, H, answer;
	public static char[][] map;
	public static boolean[][] visited;
	public static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1} ,{1, 1}};
	public static ArrayList<Character> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		W = Integer.parseInt(s[0]);
		H = Integer.parseInt(s[1]);
		map = new char[W][H];
		answer = 0;
		list.add('E');
		list.add('P');
		list.add('0');
		visited = new boolean[W][H];
		for(int i = 0; i < W; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		int[] start = new int[2];
		for(int i = 0; i < W; i++) {
			for(int j = 0; j < H; j++) {
				if(map[i][j] == 'S'){
					visited[i][j] = true;
					start[0] = i;
					start[1] = j;
					break;
				}
			}
		}
		bfs(start);
		if(answer < 0) {
			answer = 0;
		}
		System.out.println(answer);
	}
	public static void bfs(int[] start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
				@Override
				public int compare(int[] a, int[] b){
					if(map[a[0]][a[1]] != map[b[0]][b[1]]){
						return list.indexOf(map[a[0]][a[1]]) - list.indexOf(map[b[0]][b[1]]);
					}
					return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
				}
			});
		pq.offer(start);
		while(!pq.isEmpty()){
			int[] now = pq.poll();
			if(map[now[0]][now[1]] == 'E') {
				break;
			}
			answer += score(now[0], now[1]);
			for(int i = 0; i < 4; i++) {
				int y = now[0] + directions[i][0];
				int x = now[1] + directions[i][1];
				if(checkRange(y, x) && !visited[y][x]) {
					visited[y][x] = true;
					pq.offer(new int[]{y, x});
				}
			}
		}
	}
	public static boolean checkRange(int y, int x) {
		return y >= 0 && y < W && x >= 0 && x < H; 
	}
	public static int score(int y, int x) {
		if(map[y][x] == 'S'){
			return 0;
		}
		int score = 0;
		for(int[] d : directions){
			int i = y + d[0];
			int j = x + d[1];
			if(checkRange(i, j) && map[i][j] == 'P') {
				score++;
			}
		}
		if(map[y][x] == '0') {
			return score;
		}
		else {
			return score - 3;
		}
	}
}