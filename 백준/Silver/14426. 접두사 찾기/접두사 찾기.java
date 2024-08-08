import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int count = 0;
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 1; j <= str.length(); j++) {
				set.add(str.substring(0, j));
			}
		}
		
		for(int i = 0; i < m; i++) {
			if(set.contains(br.readLine())) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}