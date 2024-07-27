import java.io.*;
import java.util.*;

class Main {
	public static int[] buildings;
	public static int K;
	public static ArrayList<Integer>[] tree;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		tree = new ArrayList[K];
		for(int i = 0; i < K; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		find(0, buildings.length, 0);
		for(int i = 0; i < K; i++) {
			for(int num : tree[i]) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void find(int s, int e, int level) {
		if(level == K) {
			return;
		}
		int mid = (s + e) / 2;
		find(s, mid-1, level+1);
		tree[level].add(buildings[mid]);
		find(mid+1, e, level+1);
	}
}