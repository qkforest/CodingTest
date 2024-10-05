import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] points = new int[N][2];
		for(int i = 0; i < N; i++) {
			points[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Arrays.sort(points, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
		for(int[] p : points) {
			sb.append(p[0]).append(" ").append(p[1]).append("\n");
		}
		System.out.print(sb);
	}
}