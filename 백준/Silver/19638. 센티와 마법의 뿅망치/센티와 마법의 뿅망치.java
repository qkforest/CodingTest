import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int centi = Integer.parseInt(s[1]);
		int count = Integer.parseInt(s[2]);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		int min = 0;
		while(count > 0) {
			int max = pq.poll();
			if(max < centi) {
				pq.offer(max);
				break;
			}
			if(max > 1) {
				max /= 2; 
			}
			pq.offer(max);
			count--;
			min++;
		}
		int max = pq.poll();
		StringBuilder sb = new StringBuilder();
		if(max < centi) {
			sb.append("YES").append("\n").append(min);
		}
		else {
			sb.append("NO").append("\n").append(max);
		}
		System.out.print(sb);
	}
}