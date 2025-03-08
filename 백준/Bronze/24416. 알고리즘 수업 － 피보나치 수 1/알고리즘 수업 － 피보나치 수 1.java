import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		long[] fib = new long[41];
		fib[1]= 1;
		fib[2] = 1;
		for(int i = 3; i <= N; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		sb.append(fib[N]).append(" ").append((N == 1 || N == 2) ? 1 : N - 2);
		System.out.print(sb);
	}
}