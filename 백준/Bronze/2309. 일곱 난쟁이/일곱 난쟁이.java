import java.io.*;
import java.util.*;
class Main {
	public static int[] heights, dwarfs;
	public static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		heights = new int[7];
		dwarfs = new int[9];
		sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(dwarfs);
		dfs(0, 0, 0);
		System.out.print(sb);
	}
	public static void dfs(int level, int start, int sum) {
		if(level == 7) {
			if(sum == 100 && sb.length() == 0) {
				for(int h : heights) {
					sb.append(h).append("\n");
				}
			}
			return;
		}
		for(int i = start; i < 9; i++) {
			heights[level] = dwarfs[i];
			dfs(level+1, i+1, sum+dwarfs[i]);
		}
	}
}