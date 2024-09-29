import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<Number> stack = new ArrayDeque<>();
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < N; i++) {
			Number num = new Number(i, arr[i]);
			while(!stack.isEmpty() && stack.peekLast().value < arr[i]) {
				Number pre = stack.pollLast();
				arr[pre.idx] = arr[i];
			}
			stack.offerLast(num);
			arr[i] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.print(sb);
	}
	static class Number {
		int idx;
		int value;
		
		public Number(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}
	}
}