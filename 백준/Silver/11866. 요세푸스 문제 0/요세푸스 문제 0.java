import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		ArrayDeque<Integer> y = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder("<");
		for(int i = 1; i <= N; i++) {
			y.add(i);
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K-1; j++) {
				y.add(y.poll());
			}
			sb.append(y.poll()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.print(sb);
	}
}