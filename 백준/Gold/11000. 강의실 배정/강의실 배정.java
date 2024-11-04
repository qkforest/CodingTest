import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] times = new int[N][2];
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			times[i][0] = Integer.parseInt(s[0]);
			times[i][1] = Integer.parseInt(s[1]);
		}
		Arrays.sort(times, (a, b) ->(a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(times[0][1]);
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= times[i][0]) {
				pq.poll();
			}
			pq.offer(times[i][1]);
		}
		System.out.print(pq.size());
	}
}