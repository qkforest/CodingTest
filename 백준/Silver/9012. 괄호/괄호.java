import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			String answer = "YES";
			ArrayDeque<Character> stack = new ArrayDeque<>();
			for(char c : s.toCharArray()) {
				if(c == ')') {
					if(stack.isEmpty()) {
						answer = "NO";
						break;
					} else {
						stack.pop();
					}
				} else {
					stack.push(c);
				}
			}
			if(!stack.isEmpty()) {
				answer = "NO";
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}