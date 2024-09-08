import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] rings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < N; i++) {
			int num = rings[0];
			int deno = rings[i];
			int min = Math.min(num, deno);
			for(int d = 2; d <= min; d++) {
				if(rings[i] % d == 0 && rings[0] % d == 0) {
					num = rings[0] / d;
					deno = rings[i] / d;
				}
			}
			sb.append(num).append("/").append(deno).append("\n");
		}
		System.out.print(sb);
	}
}