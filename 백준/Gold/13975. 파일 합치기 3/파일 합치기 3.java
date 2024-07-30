import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
	public static List<Long> files;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < testcases; t++) {
			br.readLine();
			files = Arrays.stream(br.readLine().split(" "))
					.map(Long::valueOf)
		            .collect(Collectors.toList());
			sb.append(merge()).append("\n");
		}
		System.out.print(sb);
	}
	public static long merge() {
		PriorityQueue<Long> pq = new PriorityQueue<>(files);
		long cost = 0;
		while(pq.size() > 1) {
			long sum = 0;
			for(int i = 0; i < 2; i++) {
				sum += pq.poll();
			}
			cost += sum;
			pq.add(sum);
		}
		return cost;
	}
}