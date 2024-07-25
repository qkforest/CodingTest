import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("0")) {
				if(maxheap.size() == 0) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(maxheap.poll()).append("\n");
				}
			}
			else {
				for(int j = 1 ; j < s.length; j++) {
					maxheap.offer(Integer.parseInt(s[j]));
				}
			}
		}
		System.out.print(sb);
	}
}