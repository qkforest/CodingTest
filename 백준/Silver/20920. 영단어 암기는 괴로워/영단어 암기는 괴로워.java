import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() >= M) {
				map.merge(word, 1, Integer::sum);
			}	
		}
		List<String> key = new ArrayList<>(map.keySet());
		key.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1) == map.get(o2)) {
					if(o2.length() == o1.length()) {
						return o1.compareTo(o2);
					}
					return o2.length() - o1.length();
				}
				return map.get(o2).compareTo(map.get(o1));
			}
		});
		for(String w : key) {
			sb.append(w).append("\n");
		}
		System.out.print(sb);
	}
}