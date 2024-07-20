import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			map.merge(br.readLine(), 1, Integer::sum);
		}
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				if(map.get(a) == map.get(b)) {
					return a.compareTo(b);
				}
				return map.get(b) - map.get(a);
			}
		});
		System.out.print(keySet.get(0));
	}
}