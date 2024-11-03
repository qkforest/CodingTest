import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[] A = new int[N];
			int[] B = new int[M];
			s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(s[j]);
			}
			s = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				B[j] = Integer.parseInt(s[j]);
			}
			int answer = 0;
			Arrays.sort(B);
			for(int num : A) {
				int idx = 0;
				while(idx < M && B[idx] < num) {
					idx++;
				}
				answer += idx;
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}