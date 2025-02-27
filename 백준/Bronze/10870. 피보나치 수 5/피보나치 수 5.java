import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] p = new long[21];
		p[0] = 0;
		p[1] = 1;
		for(int i = 2; i <= N; i++) {
			p[i] = p[i-1] + p[i-2];
		}
		System.out.print(p[N]);
	}
}