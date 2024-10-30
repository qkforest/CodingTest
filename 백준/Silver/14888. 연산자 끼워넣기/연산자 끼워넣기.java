import java.io.*;
import java.util.*;

class Main {
	public static int N, max, min;
	public static int[] arr, op, temp;
	public static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		op = new int[N-1];
		temp = new int[N-1];
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int idx = 0;
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < 4; i++) {
			int N = Integer.parseInt(s[i]);
			while(N > 0) {
				op[idx] = i;
				idx++;
				N--;
			}
		}
		visited = new boolean[N-1];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(0);
		System.out.println(max);
		System.out.print(min);
	}
	public static void dfs(int level) {
		if(level == N-1) {
			int answer = arr[0];
			for(int i = 0; i < N-1; i++) {
				switch(temp[i]) {
					case 0 :
						answer += arr[i+1];
						break;
					case 1 :
						answer -= arr[i+1];
						break;
					case 2 :
						answer *= arr[i+1];
						break;
					case 3 :
						answer /= arr[i+1];
				}
			}
			max = Math.max(answer, max);
			min = Math.min(answer, min);
		}
		for(int i = 0; i < N-1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				temp[level] = op[i];
				dfs(level+1);
				visited[i] = false;
			}
		}
	}
}