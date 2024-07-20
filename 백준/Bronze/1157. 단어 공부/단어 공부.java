import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : str.toCharArray()) {
			map.merge(Character.toUpperCase(c), 1, Integer::sum);
		}
		
		char answer = '?'; 
		int max = 0;

		for(char c : map.keySet()) {
			int count = map.get(c);
			if(count > max) {
				max = count;
				answer = c;
			}
			else if(count == max) {
				answer = '?';
			}
		}
		
		System.out.print(answer);
	}
}