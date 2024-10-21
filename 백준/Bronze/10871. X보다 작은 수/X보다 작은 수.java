import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int X = Integer.parseInt(s[1]);
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			if(A[i] < X) {
				sb.append(A[i]).append(" ");
			}
		}
		System.out.print(sb);
	}
}