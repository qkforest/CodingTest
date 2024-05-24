import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new TreeSet<>((a, b) -> b.compareTo(a));
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			if(s[1].equals("enter")) {
				set.add(s[0]);
			} else {
				set.remove(s[0]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(String name : set) {
			sb.append(name + "\n");
		}
		System.out.print(sb);
	}
}
