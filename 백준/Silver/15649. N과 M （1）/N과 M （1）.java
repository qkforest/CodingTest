import java.io.*;
import java.util.*;
public class Main {
	public static int[] answer;
	public static boolean[] visited;
	public static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		answer = new int[M];
		visited = new boolean[N+1];
		dfs(0);
	}
	public static void dfs(int level) {
		if(level == M) {
			System.out.println(Arrays.toString(answer).replace("[", "").replace("]", "").replace(",", ""));
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				answer[level] = i;
				visited[i] = true;
				dfs(level+1);
				visited[i] = false;
			}
		}
	}
}