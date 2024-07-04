import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(cost[i], 50);
			cost[i][i] = 0;
		}
		while(true) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("-1")) {
				break;
			}
			int u = Integer.parseInt(s[0]) - 1;
			int v = Integer.parseInt(s[1]) - 1;
			cost[u][v] = 1;
			cost[v][u] = 1;
		}
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					cost[i][j] = Math.min(cost[i][j], cost[i][k]+cost[k][j]);
				}
			}
		}
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			int score = (int)Arrays.stream(cost[i]).max().getAsInt();
			map.computeIfAbsent(score,  k -> new ArrayList<>()).add(i+1);
		}
		int min = map.firstKey();
		List<Integer> cand = map.get(min);
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(cand.size()).append("\n");
		Collections.sort(cand);
		for(int a : cand) {
			sb.append(a).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb.toString());
	}
}