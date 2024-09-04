import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
				case "push" :
					deque.offer(Integer.parseInt(s[1]));
					break;
				case "pop" :
					if(!deque.isEmpty()) {
						sb.append(deque.poll());
					} else {
						sb.append(-1);
					}
					sb.append("\n");
					break;
				case "size" :
					sb.append(deque.size()).append("\n");
					break;
				case "empty" :
					if(deque.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);
					}
					sb.append("\n");
					break;
				case "front" :
					if(!deque.isEmpty()) {
						sb.append(deque.peekFirst());
					} else {
						sb.append(-1);
					}
					sb.append("\n");
					break;
				case "back" :
					if(!deque.isEmpty()) {
						sb.append(deque.peekLast());
					} else {
						sb.append(-1);
					}
					sb.append("\n");
			
			}
		}
		System.out.print(sb);
	}
}