import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			int sum = a + b;
			answer += sum;
			pq.offer(sum);
		}
		System.out.print(answer);
	}
}