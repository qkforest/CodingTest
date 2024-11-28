import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		arr = new int[N+1][K+1];
		int answer = compute(N, K);
		System.out.print(answer);
	}
	public static int compute(int N, int K) {
		if(arr[N][K] != 0) {
			return arr[N][K];
		} 
		if(N == K || K == 0) {
			arr[N][K] = 1;
		} else {
			arr[N][K] = (compute(N-1, K) + compute(N-1, K-1)) % 10007;
		}
		return arr[N][K];
	}
}