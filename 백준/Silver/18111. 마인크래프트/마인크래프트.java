import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		long B = Long.parseLong(str[2]);
		int min = Integer.MAX_VALUE;
		int max = 0;
		Map<Integer, Long> counts = new HashMap<>();
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(String s : str) {
				int h = Integer.parseInt(s);
				min = Math.min(min, h);
				max = Math.max(max, h);
				counts.merge(h, 1L, Long::sum);
			}
		}
		long minTime = Long.MAX_VALUE;
		long maxHeight = 0;
		for(int i = min; i <= max; i++) {
			long left = B;
			long time = 0;
			for(int h : counts.keySet()) {
				if(h == i) {
					continue;
				} 
				
				long count = counts.get(h);
				
				if(h > i) {
					long work = (h - i) * count;
					time += work * 2;
					left += work;
				} else {
					long work = (i - h) * count;
					time += work;
					left -=  work;
				}
				
			}
			if(left < 0) {
				continue;
			} else {
				if(time <= minTime) {
					minTime = time;
					maxHeight = i;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(minTime).append(" ").append(maxHeight);
		System.out.print(sb);
	}
}