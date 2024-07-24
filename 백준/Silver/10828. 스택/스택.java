import java.io.*;
import java.util.*;

public class Main {
	public static int top;
	public static int[] stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stack = new int[10001];
		top = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
				case "push" :
					push(Integer.parseInt(s[1]));
					break;
				case "pop" :
					sb.append(pop()).append("\n");
					break;
				case "size" :
					sb.append(size()).append("\n");
					break;
				case "empty" :
					sb.append(empty()).append("\n");
					break;
				case "top" :
					sb.append(top()).append("\n");
			}
		}
		System.out.print(sb);
	}
	public static void push(int X) {
		stack[++top] = X;
	}
	public static int pop() {
		if(top == 0) {
			return -1;
		}
		return stack[top--];
	}
	public static int size() {
		return top;
	}
	public static int empty() {
		if(top == 0) {
			return 1;
		}
		return 0;
	}
	public static int top() {
		if(top == 0) {
			return -1;
		}
		return stack[top];
	}
}