import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		arr[0] = Integer.parseInt(br.readLine());
		int d = 0;
		for(int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			d = GCD(d, arr[i]-arr[i-1]);
		}
		int answer = 0;
		for(int i = 1; i < N; i++) {
			answer += (arr[i] - arr[i-1]) / d - 1;
		}
		System.out.print(answer);
	}
	public static int GCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return GCD(b, a % b);
	}
}