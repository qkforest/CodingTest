import java.io.*;

class Main {
	public static int N, M;
	public static int[] arr;
	public static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[M];
		sb = new StringBuilder();
		
		dfs(0, 1);
		
		System.out.print(sb);
	}
	
	public static void dfs(int level, int start) {
		if(level == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			
			sb.deleteCharAt(sb.length()-1).append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			arr[level] = i;
			dfs(level+1, i);
		}
	}
}