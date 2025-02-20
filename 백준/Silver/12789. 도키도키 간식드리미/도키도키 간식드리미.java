import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int snack = 1;
		String[] s = br.readLine().split(" ");
		String answer = "Sad";
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			int o = Integer.parseInt(s[i]);
			if(o > snack) {
				stack.push(o);
			} else {
				snack++;
			}
			while(!stack.isEmpty() && snack == stack.peekFirst()) {
				stack.pop();
				snack++;
			}
		}
		if(stack.isEmpty()) {
			answer = "Nice";
		}
		System.out.print(answer);
	}
}