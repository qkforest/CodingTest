import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> dance = new HashSet<>();
		dance.add("ChongChong");
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if(dance.contains(s[0])) {
				dance.add(s[1]);
			} else if(dance.contains(s[1])) {
				dance.add(s[0]);
			}
		}
		System.out.print(dance.size());
	}
}