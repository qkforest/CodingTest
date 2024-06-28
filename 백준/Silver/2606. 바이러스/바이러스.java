import java.io.*;
class Main{
	public static int[] parents;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		parents = new int[n+1];
		for(int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			union(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		for(int i = 1; i <= n; i++) {
			find(i);
		}
		int answer = 0;
		for(int i = 2; i <= n; i++) {
			if(parents[i] == parents[1]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if(aParent == bParent) {
			return;
		}
		if(aParent < bParent) {
			parents[bParent] = aParent;
		}
		else {
			parents[aParent] = bParent;
		}
	}
	public static int find(int num) {
		if(parents[num] == num) {
			return num;
		}
		return parents[num] = find(parents[num]);
	}
}