import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, List<String>> map = new HashMap<>();
			for(int j = 0 ; j < N; j++) {
				String[] s = br.readLine().split(" ");
				List<String> temp;
				if(map.containsKey(s[1])) {
					temp = map.get(s[1]);
				} else {
					temp = new ArrayList<>();
				}
				temp.add(s[0]);
				map.put(s[1], temp);
			}
			int answer = 1;
			for(String k : map.keySet()) {
				List<String> temp = map.get(k);
				answer *= (temp.size()+1);
			}
			sb.append(answer-1).append("\n");
		}
		System.out.println(sb);
	}
}