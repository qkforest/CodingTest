import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		s = br.readLine().split(" ");
		HashMap<Integer, Integer> freq = new HashMap<>();
		HashMap<Integer, Integer> pos = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(s[i]);
			if(!pos.containsKey(num)) {
				pos.put(num, i+1);
			}
			freq.merge(num, 1, Integer::sum);
		}
		List<Map.Entry<Integer, Integer>> entrylist = new ArrayList<>(freq.entrySet());
		entrylist.sort((o1, o2) -> o2.getValue() == o1.getValue() ? Integer.compare(pos.get(o1.getKey()), pos.get(o2.getKey())) : Integer.compare(o2.getValue(), o1.getValue()));
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Integer> e : entrylist) {
			int n = e.getKey();
			int c = e.getValue();
			for(int i = 0; i < c; i++) {
				sb.append(n).append(" ");
			}
		}
		System.out.print(sb);
	}
}