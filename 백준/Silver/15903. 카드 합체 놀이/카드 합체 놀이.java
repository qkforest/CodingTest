import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		PriorityQueue<Long> pq = new PriorityQueue<>();
		s = br.readLine().split(" ");
		for(int i = 0 ; i < n; i++) {
			pq.offer(Long.parseLong(s[i]));
		}
		while(m > 0) {
			long x = pq.poll();
			long y = pq.poll();
			long sum = x + y;
			pq.offer(sum);
			pq.offer(sum);
			m--;
		}
		long answer = 0;
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.println(answer);
	}
}