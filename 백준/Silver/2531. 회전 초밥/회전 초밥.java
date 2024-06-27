import java.io.*;
import java.util.*;
class Main{
	public static int N, d, k, c;
	public static int[] parents;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		d = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		c = Integer.parseInt(s[3]);
		int[] sushi = new int[N + k];
 		Map<Integer, Long> map = new HashMap<>();
		long answer = 0;
		for(int i = 0; i < k; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
			sushi[N+i] = sushi[i];
			map.merge(sushi[i], (long) 1, Long::sum);
		}
		answer = map.size();
		if(!map.containsKey(c)) {
			answer += 1;
		}
		for(int i = k; i < N; i++) {
			map.merge(sushi[i-k], (long) -1, Long::sum);
			if(map.get(sushi[i-k]) == 0) {
				map.remove(sushi[i-k]);
			}
			sushi[i] = Integer.parseInt(br.readLine());
			map.merge(sushi[i], (long) 1, Long::sum);
			int temp = map.size();
			if(!map.containsKey(c)) {
				temp += 1;
			}
			answer = Math.max(answer, temp);
		}
		for(int i = N; i < N+k; i++) {
			map.merge(sushi[i-k], (long) -1, Long::sum);
			if(map.get(sushi[i-k]) == 0) {
				map.remove(sushi[i-k]);
			}
			map.merge(sushi[i], (long) 1, Long::sum);
			int temp = map.size();
			if(!map.containsKey(c)) {
				temp += 1;
			}
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
	}
}