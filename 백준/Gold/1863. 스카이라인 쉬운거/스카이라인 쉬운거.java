import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int y = Integer.parseInt(s[1]);
			while(!stack.isEmpty() && stack.peek() > y) {
				count++;
				stack.pop();
			}
			if(!stack.isEmpty() && stack.peek() == y) {
				continue;
			}
			stack.push(y);
		}
		while(!stack.isEmpty()) {
			if(stack.peek() > 0) {
				count++;
			}
			stack.pop();
		}
		System.out.print(count);
	}
}