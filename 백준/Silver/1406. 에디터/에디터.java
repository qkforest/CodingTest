import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();
		for(char c : str.toCharArray()) {
			left.push(c);
		}
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
				case "L" :
					if(left.size() > 0) {
						right.addFirst(left.pop());
					}
					break;
				case "D" :
					if(right.size() > 0) {
						left.push(right.poll());
					}
					break;
				case "B" :
					if(left.size() > 0) {
						left.pop();
					}
					break;
				case "P" :
					left.push(s[1].charAt(0));
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!left.isEmpty()) {
			sb.append(left.pollLast());
		}
		while(!right.isEmpty()) {
			sb.append(right.pollFirst());
		}
		System.out.print(sb);
	}
}