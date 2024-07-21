import java.io.*;

class Main {
	public static StringBuilder sb;
	public static int N, M;
	public static int[] arr;
	public static void dfs(int start, int level) {
		if(level == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.deleteCharAt(sb.length()-1).append("\n");
			return;
		}
		for(int i = start; i <= N; i++) {
			arr[level] = i;
			dfs(i+1, level+1);
		}
	}
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		sb = new StringBuilder();
		arr = new int[M];
		dfs(1, 0);
		System.out.print(sb);
	}	
}