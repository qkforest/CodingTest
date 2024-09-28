import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Building> stack = new ArrayDeque<>();
		long answer = 0;
		for(int i = 0; i < N; i++) {
			Building b = new Building(i, Integer.parseInt(br.readLine()));
			while(!stack.isEmpty() && stack.peekLast().height <= b.height) {
				Building pre = stack.pollLast();
				answer += i - pre.pos - 1;
			}
			stack.offerLast(b);
		}
		while(!stack.isEmpty()) {
			Building pre = stack.pollLast();
			answer += N - pre.pos - 1;
		}
		System.out.print(answer);
	}
	static class Building {
		int pos;
		int height;
		
		public Building(int pos, int height) {
			this.pos = pos;
			this.height = height;
		}
	}
}