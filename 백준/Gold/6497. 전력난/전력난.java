import java.io.*;
import java.util.*;
public class Main {
	static public int[] parents;
	static public int[][] costs;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] s = br.readLine().split(" ");
			int m = Integer.parseInt(s[0]);
			int n = Integer.parseInt(s[1]);
			if(m == n) {
				break;
			}
			parents = new int[m+1];
			costs = new int[n][3];
			long answer = 0;
			for(int i = 0; i < n; i++) {
				s = br.readLine().split(" ");
				costs[i][0] = Integer.parseInt(s[0]);
				costs[i][1] = Integer.parseInt(s[1]);
				costs[i][2] = Integer.parseInt(s[2]);
				answer += costs[i][2];
			}
			for(int i = 1; i <= m; i++) {
				parents[i] = i;
			}
			Arrays.sort(costs, (a, b) -> a[2] - b[2]);
			for(int[] c : costs) {
				if(union(c[0], c[1])) {
					answer -= c[2];
				}
			}
			System.out.println(answer);
		} 
	}
	public static boolean union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if(aParent == bParent) {
			return false;
		}
		if(aParent < bParent) {
			parents[bParent] = aParent;
		} else {
			parents[aParent] = bParent;
		}
		return true;
	}
	public static int find(int num) {
		if(num == parents[num]) {
			return num;
		}
		return parents[num] = find(parents[num]);
	}
}