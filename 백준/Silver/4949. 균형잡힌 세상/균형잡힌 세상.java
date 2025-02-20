import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals(".")) {
			ArrayDeque<Character> stack = new ArrayDeque<>();
			String answer = "yes";
			for(char c : s.toCharArray()) {
				if(c == '(' || c == '{' || c == '[') {
					stack.push(c);
				} else if(c == ')' || c == '}' || c == ']') {
					if(stack.isEmpty()) {
						answer = "no";
					} 
					else {
						if((c == ')' && stack.peekFirst() == '(') || (c == '}' && stack.peekFirst() == '{') || (c == ']' && stack.peekFirst() == '[')) {
							stack.pop();
						} else {
							answer = "no";
						}
					}
				}
				if(answer.equals("no")) {
					break;
				}
			}
			if(!stack.isEmpty()) {
				answer = "no";
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}