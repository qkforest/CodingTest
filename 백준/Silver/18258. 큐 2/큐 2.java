import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i= 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
				case "push" : 
					queue.add(Integer.parseInt(s[1]));
					break;
				case "pop" :
					if(queue.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(queue.poll());	
					}
					sb.append("\n");
					break;
				case "size" :
					sb.append(queue.size()).append("\n");
					break;
				case "empty" :
					if(queue.isEmpty()) {
						sb.append(1);
					} else {
						sb.append(0);	
					}
					sb.append("\n");
					break;
				case "front" :
					if(queue.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(queue.peekFirst());
					}
					sb.append("\n");
					break;
				case "back" :
					if(queue.isEmpty()) {
						sb.append(-1);
					} else {
						sb.append(queue.peekLast());
					}
					sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}