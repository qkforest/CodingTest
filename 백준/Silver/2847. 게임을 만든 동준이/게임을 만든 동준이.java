import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> stack = new ArrayDeque<>();
		for(int i = 0;i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		int min = stack.pop();
		int answer = 0;
		while(!stack.isEmpty()) {
			int now = stack.pop();
			if(now >= min) {
				answer += (now - min) + 1 ;
				min--;
			} else {
				min = now;
			}
		}
		System.out.print(answer);
	}
}