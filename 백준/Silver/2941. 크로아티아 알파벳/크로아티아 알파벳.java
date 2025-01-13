import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		String s = br. readLine();
		int idx = 0;
		Set<String> set = new HashSet<>(Arrays.asList("c=", "c-", "d-", "lj", "nj", "s=", "z="));
		while(idx < s.length()) {
			if(idx+1 < s.length() && set.contains(s.substring(idx, idx+2))) {
				answer++;
				idx += 2;
			}
			else if(idx+2 < s.length() && s.substring(idx, idx+3).equals("dz=")) {
				answer++;
				idx += 3;
			}
			else {
				answer++;
				idx++;
			}
		}
		System.out.print(answer);
	}
}