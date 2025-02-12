import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Set<String> set = new HashSet<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			if(set.contains(name)) {
				pq.offer(name);
			}
		}
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	}
}