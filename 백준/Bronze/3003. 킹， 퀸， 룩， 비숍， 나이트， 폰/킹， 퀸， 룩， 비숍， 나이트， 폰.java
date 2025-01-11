import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] set = {1, 1, 2, 2, 2, 8};
		int[] count = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < 6; i++) {
			count[i] = set[i] - count[i];
		}
		for(int c : count) {
			sb.append(c).append(" ");
		}
		System.out.print(sb);
	}
}