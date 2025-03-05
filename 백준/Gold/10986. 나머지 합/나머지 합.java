import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int sum = 0;
		long[] arr = new long[M]; 
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			sum = (sum + Integer.parseInt(s[i])) % M;
			arr[sum]++;
		}
		long answer = arr[0];
		for(int i = 0; i < M; i++) {
			answer += arr[i] * (arr[i] - 1) / (long)2;
		}
		System.out.print(answer);
	}
}