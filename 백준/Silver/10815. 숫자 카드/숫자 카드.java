import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		Set<Integer> set = new HashSet<>();
		String[] s = br.readLine().split(" ");
		for(String t : s) {
			set.add(Integer.parseInt(t));
		}
		int size = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		s = br.readLine().split(" ");
		for(int i = 0; i < size; i++) {
			if(set.contains(Integer.parseInt(s[i]))) {
				sb.append("1");
			}
			else {
				sb.append("0");
			}
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}