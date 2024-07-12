import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				deque.pop();
			}
			else {
				deque.push(n);
			}
		}
		long answer = 0;
		while(!deque.isEmpty()) {
			answer += deque.pop();
		}
		System.out.println(answer);
	}
}