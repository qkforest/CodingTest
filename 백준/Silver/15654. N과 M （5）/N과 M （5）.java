import java.util.*;
import java.io.*;

class Main {
	public static int N, M;
	public static int[] arr, temp;
	public static StringBuilder answer;
	public static Set<String> set;
	public static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		answer = new StringBuilder();
		temp = new int[M];
		set = new HashSet<>();
		
		Arrays.sort(arr);
		
		visited = new boolean[N];
		
		dfs(0);
		
		System.out.print(answer.toString());
	}
	
	public static void dfs(int level) {
		if(level == M) {
			StringBuilder sb = new StringBuilder();
			
			for(int num : temp) {
				sb.append(num).append(" ");
			}
			
			String str = sb.deleteCharAt(sb.length()-1).toString();
			
			if(set.add(str)) {
				answer.append(sb).append("\n");
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
}