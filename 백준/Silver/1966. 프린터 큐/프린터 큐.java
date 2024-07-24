import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < testCases; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
			Queue<int[]> q = new LinkedList<>();
			s = br.readLine().split(" ");
			for(int i = 0; i < N; i++) {
				pq.offer(Integer.parseInt(s[i]));
				q.offer(new int[] {Integer.parseInt(s[i]), i});
			}
			int answer = 0;
			while(!q.isEmpty()) {
				while(pq.peek() != q.peek()[0]) {
					q.offer(q.poll());
				}
				int[] now = q.poll();
				pq.poll();
				answer++;
				if(now[1] == M) {
					sb.append(answer).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}