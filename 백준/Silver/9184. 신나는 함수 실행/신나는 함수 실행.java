import java.io.*;

class Main {
	public static int[][][] dp;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		dp = new int[21][21][21];
		while(!(str = br.readLine()).equals("-1 -1 -1")) {
			String[] s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			sb.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append("\n");
		}
		System.out.print(sb);
	}
	public static int w(int a, int b, int c) {
		if(a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if(a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}
		if(a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
}