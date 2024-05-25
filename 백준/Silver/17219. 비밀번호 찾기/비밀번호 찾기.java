import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Map<String, String> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			map.put(s[0], s[1]);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())+"\n");
		}
		System.out.print(sb);
	}
}
