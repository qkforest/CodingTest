import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < N; i++) {
			if(A[i] == 0) {
				queue.addFirst(B[i]);
			}
		}
		int M = Integer.parseInt(br.readLine());
		int[] C = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < M; i++) {
			queue.add(C[i]);
		}
		for(int i = 0; i < M; i++) {
			sb.append(queue.removeFirst()).append(" ");
		}
		System.out.print(sb);
	}
}