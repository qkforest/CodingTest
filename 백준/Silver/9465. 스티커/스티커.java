import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < testCases; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n];
			for(int i = 0; i < 2; i++) {
				stickers[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			long answer = 0;
			if(n == 1) {
				sb.append(Math.max(stickers[0][0], stickers[1][0]));
			} else {
				stickers[0][1] += stickers[1][0];
				stickers[1][1] += stickers[0][0];
				answer = Math.max(stickers[0][1], stickers[1][1]);
				for(int i = 2; i < n; i++) {
					for(int j = 0; j < 2; j++) {
						int a = Math.max(stickers[0][i-2], stickers[1][i-2]);
						int b = stickers[(j+1)%2][i-1];
						stickers[j][i] += Math.max(a, b);
						answer = Math.max(answer, stickers[j][i]);
					}
				}
				sb.append(answer);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}