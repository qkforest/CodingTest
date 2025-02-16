import java.io.*;
class Main {
	public static int  N, answer;
	public static int[] arr;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		arr[0] = Integer.parseInt(br.readLine());
		int d = Integer.MAX_VALUE;
		for(int i = 1; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			d = Math.min(d, arr[i] - arr[i-1]);
		}
		answer = Integer.MAX_VALUE;
		while(find(d)) {
			d--;
		}
		System.out.print(answer);
	}
	public static boolean find(int d) {
		int count = 0;
		for(int i = 1; i < N; i++) {
			int dis = arr[i] - arr[i-1];
			if(dis % d != 0) {
				return true;
			}
			count += ((dis / d) - 1);
		}
		answer = Math.min(answer, count);
		return false;
	}
}