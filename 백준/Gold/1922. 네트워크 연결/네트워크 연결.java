import java.io.*;
import java.util.*;
public class Main {
	static int[] parents;
	static int[][] costs;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		costs = new int[M][3];
		
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
            costs[i][0] = Integer.parseInt(s[0]);
            costs[i][1] = Integer.parseInt(s[1]);
            costs[i][2] = Integer.parseInt(s[2]);
		}
		Arrays.sort(costs, (a, b) -> a[2] - b[2]);
		int answer = 0;
		for(int[] c : costs) {
			if(union(c[0], c[1])) {
				answer += c[2];
			}
		}
		System.out.print(answer);
	}
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return false;
		}
		if(rootA > rootB) {
			parents[rootA] = rootB;
		} else {
			parents[rootB] = rootA;
		}
		return true;
	}
	public static int find(int num) {
		if(parents[num] == num) {
			return num;
		}
		return parents[num] = find(parents[num]);
	}
}