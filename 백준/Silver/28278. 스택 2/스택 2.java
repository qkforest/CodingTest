import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if(s.length == 2) {
				stack.push(Integer.parseInt(s[1]));
			} else {
				if(s[0].equals("2")) {
					if(stack.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(stack.pop());
					}
				}
				else if(s[0].equals("3")) {
					sb.append(stack.size());
				}
				else if(s[0].equals("4")) {
					if(stack.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				else {
					if(stack.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(stack.peekFirst());
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}