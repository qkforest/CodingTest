import java.io.*;

public class Main {
	public static StringBuilder sb;
	public static boolean[] visited;
	public static int[] arr;
	public static int N, M;
	public static void dfs(int level) {
		if(level == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				arr[level] = i;
				visited[i] = true;
				dfs(level+1);
				visited[i] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		visited = new boolean[N+1];
		arr = new int[M];
		dfs(0);
		System.out.print(sb);
	}
}