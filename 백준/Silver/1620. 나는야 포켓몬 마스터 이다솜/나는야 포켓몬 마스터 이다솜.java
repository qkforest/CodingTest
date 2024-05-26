import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Map<Integer, String> idx = new HashMap<>();
		Map<String, Integer> name = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String n = br.readLine();
			idx.put(i, n);
			name.put(n, i);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String q = br.readLine();
			if(isNumber(q)) {
				sb.append(idx.get(Integer.parseInt(q))+"\n");
			} else {
				sb.append(name.get(q)+"\n");
			}
		}
		System.out.print(sb);
	}
	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}
}
