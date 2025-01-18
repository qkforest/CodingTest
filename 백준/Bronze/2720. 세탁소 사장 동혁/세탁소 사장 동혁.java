import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] coins = {25, 10, 5, 1};
		for(int i = 0; i < T; i++) {
			int change = Integer.parseInt(br.readLine());
			int[] answer = new int[4];
			for(int j = 0; j < 4 ; j++) {
				answer[j] = change / coins[j];
				change -= answer[j] * coins[j];
			}
			for(int n : answer) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}