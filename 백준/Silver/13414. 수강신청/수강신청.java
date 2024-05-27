import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		Set<String> set = new LinkedHashSet<>();
		for(int i = 0; i < L; i++) {
			String num = br.readLine();
			if(set.contains(num)) {
				set.remove(num);
				set.add(num);
			} else {
				set.add(num);
			}
		}
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(String num : set) {
			sb.append(num).append("\n");
			idx++;
			if(idx == K) {
				break;
			}
		}
		System.out.print(sb);
	}
}