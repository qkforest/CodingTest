import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   	int len = Integer.parseInt(br.readLine());
    String control = br.readLine();
		int[] blocks = new int[len];
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < len; i++) {
			blocks[i] = Integer.parseInt(str[i]);
		}
		int answer = 0;
		Stack<int[]> stack = new Stack<>();
		Set<String> set = new HashSet<>();
		int[] now = {0, 0};
		stack.push(new int[] {0, 0, 1});
		set.add(Arrays.toString(now));
		for(int i = 0; i < len; i++) {
			switch(control.charAt(i)) {
				case 'R':
					now[1] += 1;
					break;
				case 'L':
					now[1] -= 1;
					break;
				case 'U':
					now[0] -= 1;
					break;
				case 'D':
					now[0] += 1;
			}
			String s = Arrays.toString(now);
			while(set.contains(s)) {
				int[] r = stack.pop();
				set.remove(Arrays.toString(Arrays.copyOfRange(r, 0, 2)));
			}
			int[] a = new int[]{now[0], now[1], blocks[i]};
			stack.push(a);
			set.add(Arrays.toString(now));
		}
		while(!stack.isEmpty()) {
			int[] score = stack.pop();
			answer += score[2];
		}
		System.out.println(answer);
	}
}