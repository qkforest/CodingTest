import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int e = Integer.parseInt(str[1]);
			int s = Integer.parseInt(str[0]);
			if(!map.containsKey(e)) {
				map.put(e, s);
			}
			else if(map.get(e) > s) {
				map.put(e, s);
			}
 		}
		int pre = Integer.MAX_VALUE;
		int answer = 0;
		for(int k : map.keySet()) {
			int s = map.get(k);
			if(s >= pre) {
				continue;
			} else {
				if(k > pre) {
					answer += pre - s; 
				} else {
					answer += k - s; 
				}
				pre = s;
			}
		}
		System.out.print(answer);
	}
}