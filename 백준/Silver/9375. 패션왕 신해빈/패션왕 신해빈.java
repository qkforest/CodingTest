import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < testcases; t++) {
			Map<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				map.merge(s[1], 1, Integer::sum);
			}
			int answer = 1;
			for(String type : map.keySet()) {
				answer *= (map.get(type)+1);
			}
			sb.append(answer-1).append("\n");
		}
		
		// 출력
		System.out.print(sb);
	}
}