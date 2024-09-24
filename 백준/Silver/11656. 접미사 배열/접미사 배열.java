import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		PriorityQueue<String> pq = new PriorityQueue<>();
		int len = S.length();
		for(int i = 0; i < len; i++) {
			pq.offer(S.substring(i, len));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	}
}