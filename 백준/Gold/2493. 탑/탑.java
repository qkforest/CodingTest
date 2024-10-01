import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] answer = new int[N];
		ArrayDeque<Building> stack = new ArrayDeque<>();
		for(int i = N-1; i >= 0; i--) {
			int h = Integer.parseInt(s[i]);
			while(!stack.isEmpty() && stack.peekLast().height <= h) {
				Building pre = stack.pollLast();
				answer[pre.idx] = i+1;
			}
			stack.offerLast(new Building(i, h));
 		}
		StringBuilder sb = new StringBuilder();
		for(int idx : answer) {
			sb.append(idx).append(" ");
		}
		System.out.print(sb);
		
	}
	static class Building {
		int idx;
		int height;
		
		public Building(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
}