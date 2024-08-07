import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(",");
			for(String keyword : s) {
				if(set.contains(keyword)) {
					set.remove(keyword);
				}
			}
			sb.append(set.size()).append("\n");
		}
		System.out.print(sb);
	}
}