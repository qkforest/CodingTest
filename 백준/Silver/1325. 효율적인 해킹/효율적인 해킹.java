import java.io.*;
import java.util.*;

public class Main {
	public static int n, m;
	public static List<Integer>[] lists;
	public static int[] hackCounts;
	public static boolean[] visited;
	public static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		lists = new List[n + 1];
		hackCounts = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			lists[start].add(end);
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];

			visited[i] = true;
			hackCounts[i]++;
			queue.add(i);

			bfs();
		}

		int maxHackCount = 0;
		for (int i = 1; i <= n; i++) {
			maxHackCount = Math.max(maxHackCount, hackCounts[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (hackCounts[i] == maxHackCount) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
    
    static void bfs() {
		while (!queue.isEmpty()) {
			int currentIdx = queue.remove();

			for (int nextIdx : lists[currentIdx]) {
				if (!visited[nextIdx]) {
					visited[nextIdx] = true;
					hackCounts[nextIdx]++;
					queue.add(nextIdx);
				}
			}
		}
	}
}