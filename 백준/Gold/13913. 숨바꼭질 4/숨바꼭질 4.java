import java.io.*;
import java.util.*;
public class Main {
	public static int N, K;
	public static int MAX = 100001;
	public static Stack<Integer> stack;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		stack = new Stack<>();
		bfs();
		System.out.println(stack.size()-1);
		System.out.print(stack.pop());
		while(!stack.isEmpty()) {
			System.out.print(" " + stack.pop());
		}
	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[MAX];
		int[] previous = new int[MAX];
		q.offer(N);
		visited[N] = true;
		while(!q.isEmpty()) {
				int now = q.poll();
				if(now == K) {
					int i = K;
					stack.push(i);
					while(i != N) {
						stack.push(previous[i]);
						i = previous[i];
					}
					return;
				}
				for(int i = 0; i < 3; i++) {
					int next = 0;
					if(i == 0) {
						next = now + 1;
					} else if(i == 1) {
						next = now - 1;
					}
					else {
						next = now * 2;
				}
				if(next >= 0 && next < MAX && !visited[next]) {
					visited[next] = true;
					previous[next] = now;
					q.offer(next);
				}
				
			}
		}
	}
}