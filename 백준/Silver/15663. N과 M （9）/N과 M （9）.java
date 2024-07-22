import java.io.*;
import java.util.*;

class Main {
	public static int N, M;
	public static int[] arr;
	public static int[] temp;
	public static boolean[] visited;
	public static Set<String> set;
	public static StringBuilder answer; 
	public static void dfs(int level) {
		if(level == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : temp) {
				sb.append(num).append(" ");
			}
			String s = sb.deleteCharAt(sb.length()-1).toString();
			if(!set.contains(s)) {
				set.add(s);
				answer.append(s).append("\n");
			}
			return;
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				temp[level] = arr[i];
				visited[i] = true;
				dfs(level+1);
				visited[i] = false;
			}
		}
	}
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		visited = new boolean[N];
		temp = new int[M];
		set = new HashSet<>();
		answer = new StringBuilder();
		dfs(0);
		System.out.print(answer);
 	}
}