import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] b = new int[N];
		for(int l = 0; l < M; l++) {
			s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]) - 1;
			int j = Integer.parseInt(s[1]);
			int k = Integer.parseInt(s[2]);
			for(int a = i; a < j; a++) {
				b[a] = k;
			}
		}
		for(int ball : b) {
			sb.append(ball).append(" ");
		}
		System.out.print(sb);
	}
}