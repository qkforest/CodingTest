import java.io.*;

class Main {
	public static int k;
	public static int[] arr, lottery;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		lottery = new int[6];
		sb = new StringBuilder();
		
		while(!(line = br.readLine()).equals("0")) {
			String[] s = line.split(" ");
			k = Integer.parseInt(s[0]);
			arr = new int[k];
			for(int i = 1; i <= k; i++) {
				arr[i-1] = Integer.parseInt(s[i]);
			}
			dfs(0, 0);
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void dfs(int start, int level) {
		if(level == 6) {
			for(int n : lottery) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = start; i < k; i++) {
			lottery[level] = arr[i];
			dfs(i+1, level+1);
		}
	}
}