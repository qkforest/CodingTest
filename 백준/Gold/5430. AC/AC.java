import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < T; i++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			s = s.substring(1, s.length()-1);
			ArrayDeque<Integer> deque;
			if (s.length() == 0) {
				deque = new ArrayDeque<>();
			} else {
				List<Integer> x = Arrays.stream(s.split(",")).map(Integer::valueOf).collect(Collectors.toList());
				deque = new ArrayDeque<>(x);
			}

			boolean order = true;
			boolean error = false;
			for (char c : p) {
				if (c == 'R') {
					order = !order;
				} else {
					if (deque.isEmpty()) {
						answer.append("error");
						error = true;
						break;
					} else {
						if (order) {
							deque.pollFirst();
						} else {
							deque.pollLast();
						}
					}
				}
			}
			if (!error) {
				answer.append("[");
				if (order) {
					while (!deque.isEmpty()) {
						answer.append(deque.pollFirst()).append(",");
					}
				} else {
					while (!deque.isEmpty()) {
						answer.append(deque.pollLast()).append(",");
					}
				}
				if(answer.charAt(answer.length()-1) ==',') {
					answer.setCharAt(answer.length() - 1, ']');
				} else {
					answer.append("]");
				}
			}
			answer.append("\n");
		}
		System.out.print(answer);
	}
}