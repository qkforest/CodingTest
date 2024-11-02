import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(s[0]);
			arr[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(arr, (a, b) -> (a[0] == b[0])? a[1] - b[1] : a[0] - b[0]);
		StringBuilder sb = new StringBuilder();
		for(int[] a : arr) {
			sb.append(a[0]).append(" ").append(a[1]).append("\n");
		}
		System.out.print(sb);
	}
}