import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		
		for(int i = 0; i < N; i++) {
			int[] rows = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int num : rows) {
				pq.offer(num);
			}
		}
		for(int i = 0; i < N-1; i++) {
			pq.poll();
		}
		System.out.print(pq.poll());
		
	}
}