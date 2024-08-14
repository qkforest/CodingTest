import java.util.*;
import java.io.*;

class Main {
	public static int N, M;
	public static int[] arr, temp;
	public static StringBuilder answer;
	public static Set<String> set;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		temp = new int[M];
		answer = new StringBuilder();
		set = new HashSet<>();
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		System.out.print(answer);
	}
	
	public static void dfs(int level, int start) {
		if(level == M) {
			StringBuilder sb = new StringBuilder();
			for(int num : temp) {
				sb.append(num).append(" ");
			}
			String t = sb.deleteCharAt(sb.length()-1).toString();
			if(!set.contains(t)) {
				set.add(t);
				answer.append(t).append("\n");
			}
			return;
		}
		
		for(int i = start; i < N; i++) {
			temp[level] = arr[i];
			dfs(level+1, i+1);
		}
	}
}