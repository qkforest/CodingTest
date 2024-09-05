import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			while(num < n && (stack.isEmpty() || stack.peek() != x)) {
				num++;
				stack.push(num);
				sb.append("+").append("\n");
			}
			if(stack.peek() == x) {
				sb.append("-").append("\n");
				stack.pop();
			}
		}
		
		if(stack.isEmpty()) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
	}
}