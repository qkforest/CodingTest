import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		List<String> list = new ArrayList<>();
		String temp = "";
		for(char c : s.toCharArray()) {
			if(isNumber(c)) {
				temp += c;
			} else {
				list.add(temp);
				temp = "";
				list.add("" + c);
			}
		}
		list.add(temp);
		Stack<String> stack = new Stack<>();
		int idx = 0;
		while(idx < list.size()) {
			if(list.get(idx).equals("+")) {
				int a = Integer.parseInt(stack.pop());
				idx++;
				int b = Integer.parseInt(list.get(idx));
				stack.push(String.valueOf(a+b));
			} else {
				stack.push(list.get(idx));
			}
			idx++;
		}
		if(stack.size() == 1) {
			System.out.println(stack.pop());
		} else {
			Stack<String> stack2 = new Stack<>();
			while(!stack.isEmpty()) {
				stack2.push(stack.pop());
			}
			int answer = Integer.parseInt(stack2.pop());
			while(!stack2.isEmpty()) {
				String now = stack2.pop();
				if(now.equals("-")) {
					continue;
				} else {
					answer = answer - Integer.parseInt(now);
				}
			}
			System.out.println(answer);
		}
	}
	public static boolean isNumber(char c) {
		if(c >= 48 && c <= 57){
			return true;
		}
		return false;
	}
}