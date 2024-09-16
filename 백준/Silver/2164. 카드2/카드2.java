import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= n ; i++) {
			queue.offer(i);
		}
		while(queue.size() > 1) {
			queue.poll();
			queue.offer(queue.poll());
		}
		System.out.print(queue.poll());
	}
}