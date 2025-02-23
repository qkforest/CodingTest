import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] fac = new long[N+1];
		fac[0] = 1;
		for(int i = 1; i <= N; i++) {
			fac[i] = i * fac[i-1];
		}
		System.out.print(fac[N]);
	}
}