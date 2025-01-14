import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			Map<Character, Integer> map = new HashMap<>();
			char pre = s.charAt(0);
			for(char c : s.toCharArray()) {
				if(c != pre) {
					map.merge(pre, 1, Integer::sum);
					pre = c;
				}
			}
			map.merge(s.charAt(s.length()-1), 1, Integer::sum);
			boolean word = true;
			for(int count : map.values()) {
				if(count > 1) {
					word = false;
					break;
				}
			}
			if(word) {
				answer++;
			}
		}
		System.out.print(answer);
	}
}