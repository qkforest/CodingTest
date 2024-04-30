import java.io.*;
import java.util.*;
public class Main {
	public static int F, S, G;
	public static List<Integer> buttons;
	public static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		F = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		G = Integer.parseInt(s[2]);
		buttons = new ArrayList<>();
		visited = new boolean[F+1];
		if(!s[3].equals("0")) {
			buttons.add(Integer.parseInt(s[3]));
		}
		if(!s[4].equals("0")) {
			buttons.add((-1) * Integer.parseInt(s[4]));
		}
		System.out.println(bfs());
	}
	public static String bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {S, 0});
		visited[S] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			if(now[0] == G) {
				return String.valueOf(now[1]);
			}
			for(int b : buttons) {
				int next = now[0] + b;
				if(next >= 1 && next <= F && !visited[next]) {
					visited[next] = true;
					q.offer(new int[] {next, now[1]+1});
				}
			}
		}
		return "use the stairs";
	}

}