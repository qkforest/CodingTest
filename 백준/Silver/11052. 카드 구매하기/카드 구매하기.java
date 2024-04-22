import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N+1];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			cost[i+1] = Integer.parseInt(s[i]);
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j < i; j++) {
				cost[i] = Math.max(cost[i], cost[j] + cost[i-j]);
			}
		}
		System.out.println(cost[N]);
	}
}