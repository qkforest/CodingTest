import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		long[] arr = new long[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] += arr[i-1] + Integer.parseInt(s[i-1]);
		}
		long answer = Long.MIN_VALUE;
		for(int i = K; i <= N; i++) {
			answer = Math.max(answer, arr[i]-arr[i-K]);
		}
		System.out.print(answer);
	}
}