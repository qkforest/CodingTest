import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] += arr[i-1] + Integer.parseInt(s[i-1]);
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			sb.append(arr[Integer.parseInt(s[1])] - arr[Integer.parseInt(s[0])-1]).append("\n");
		}
		System.out.print(sb);
	}
}