import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] arr = br.readLine().toCharArray();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(char c : arr) {
			pq.offer(c - '0');
		}
		while(!pq.isEmpty()) {
			sb.append(pq.poll());
		}
		System.out.print(sb);
	}
}