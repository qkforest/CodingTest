import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<String> deque = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if(s.length == 2) {
				if(s[0].equals("1")) {
					deque.addFirst(s[1]);
				} else {
					deque.addLast(s[1]);
				}
			} else {
				if(s[0].equals("5")) {
					sb.append(deque.size());
				} else if(s[0].equals("6")) {
					if(deque.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				} else {
					if(deque.isEmpty()) {
						sb.append(-1);
					} else {
						if(s[0].equals("3")) {
							sb.append(deque.removeFirst());
						} else if(s[0].equals("4")) {
							sb.append(deque.removeLast());
						} else if(s[0].equals("7")) {
							sb.append(deque.peekFirst());
						} else {
							sb.append(deque.peekLast());
						}
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}