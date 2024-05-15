import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] cards1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < M; i++) {
			if(map.containsKey(cards1[i])) {
				map.put(cards1[i], map.get(cards1[i])+1);
			} else {
				map.put(cards1[i], 1);
			}
		}
		br.readLine();
		int[] cards2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for(int c : cards2) {
			int ans = 0;
			if(map.containsKey(c)) {
				ans = map.get(c);
			}
			sb.append(ans + " ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb);
	}
}