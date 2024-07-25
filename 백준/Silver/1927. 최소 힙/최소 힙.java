import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(minheap.size() == 0) {
					sb.append(0).append("\n");
				}
				else {
					sb.append(minheap.poll()).append("\n");
				}
			}
			else {
				minheap.offer(x);
			}
		}
		System.out.print(sb);
	}
}