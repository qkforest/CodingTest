import java.io.*;
import java.util.*;
public class Main {
	public static Set<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			for(int j = 1; j <= s.length()- i; j++) {
				set.add(s.substring(i, i+j));
			}
		}
		System.out.print(set.size());
	}
}
