import java.util.*;
import java.io.*;
import java.util.Map.Entry;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] scores = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(scores[i], 50);
			scores[i][i] = 0;
		}
		
		while(true) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("-1")) {
				break;
			}
			int A = Integer.parseInt(s[0]) - 1;
			int B = Integer.parseInt(s[1]) - 1;
			scores[A][B] = 1;
			scores[B][A] = 1;
 		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					scores[i][j] = Math.min(scores[i][j], scores[i][k]+ scores[k][j]);
				}
			}
		}
		
		TreeMap<Integer, List<Integer>> members = new TreeMap<>();
		for(int i = 0; i < N; i++) {
			int max = Arrays.stream(scores[i]).max().getAsInt();
			members.computeIfAbsent(max, k -> new ArrayList<Integer>()).add(i+1);
		}
		
		StringBuilder sb = new StringBuilder();
		Entry<Integer, List<Integer>> answer = members.firstEntry();
		sb.append(answer.getKey()).append(" ").append(answer.getValue().size()).append("\n");
		for(int idx : answer.getValue()) {
			sb.append(idx).append(" ");
		}
		System.out.print(sb);
	}
}