import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] b = new int[N];
		for(int i = 0; i < N; i++) {
			b[i] = i+1;
		}
		for(int k = 0; k < M; k++) {
			s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]) - 1;
			int j = Integer.parseInt(s[1]) - 1;
			int temp = b[i];
			b[i] = b[j];
			b[j] = temp;
		}
		for(int ball : b) {
			sb.append(ball).append(" ");
		}
		System.out.print(sb);
	}
}