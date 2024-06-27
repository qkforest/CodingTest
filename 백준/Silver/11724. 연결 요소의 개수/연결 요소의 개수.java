import java.io.*;
import java.util.*;
class Main{
	public static int N, M;
	public static int[] parents;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		int answer = N;
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			if(merge(u, v)) {
				answer--;
			}
		}
		System.out.println(answer);
	}
	public static boolean merge(int a, int b) {
		int aParent = parent(a);
		int bParent = parent(b);
		if(aParent == bParent) {
			return false;
		}
		if(aParent < bParent) {
			parents[bParent] = aParent;
		}
		else {
			parents[aParent] = bParent;
		}
		return true;
	}
	public static int parent(int num) {
		if(parents[num] == num) {
			return num;
		}
		return parents[num] = parent(parents[num]);
	}
}