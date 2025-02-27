import java.io.*;
class Main {
	public static int c;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			c = 0;
			String p = br.readLine();
			sb.append(recursion(p, 0, p.length()-1)).append(" ").append(c).append("\n");
		}
		System.out.print(sb);
	}
	public static int recursion(String s, int l, int r) {
		c++;
		if(l >= r) {
			return 1;
		} else if(s.charAt(l) != s.charAt(r)) {
			return 0;
		}
		return recursion(s, l+1, r-1);
	}
}