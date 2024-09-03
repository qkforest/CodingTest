import java.io.*;
import java.util.*;
class Main {
	public static StringBuilder sb;
	public static int[] arr;
	public static int N, M;
	public static Set<String> set;	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		set = new HashSet<>();
		arr = new int[M];
		
		dfs(0);
		
		System.out.print(sb);
		
	}
	
	public static void dfs(int level) {
		if(level == M) {
			StringBuilder temp = new StringBuilder();
			for(int num : arr) {
				temp.append(num).append(" ");
			}
			String str = temp.toString();
			if(set.add(str)) {
				sb.append(str).append("\n");
			}
			return;
		}
		for(int i = 1; i <= N; i++) {
			arr[level] = i;
			dfs(level+1);
		}
	}
}