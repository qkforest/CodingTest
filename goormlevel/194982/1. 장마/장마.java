import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] houses = new int[N];
		str = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(str[i]);
		}
		Queue<int[]> q = new LinkedList<>();
		for(int i = 1; i <= M; i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]) - 1;
			int e = Integer.parseInt(str[1]) - 1;
			q.add(new int[] {s, e});
			for(int j = s; j <= e; j++) {
				houses[j]++;
			}
			if(i % 3 == 0) {
				boolean[] water = new boolean[N];
				while(!q.isEmpty()) {
					int[] idx = q.poll();
					for(int k = idx[0]; k <= idx[1]; k++) {
						if(!water[k]) {
							houses[k]--;
							water[k] = true;
						}
					}
				}
			}
		}
		String answer = "" + houses[0];
		for(int i = 1; i < N; i++) {
			answer += " " + houses[i];
		}
		System.out.println(answer);
	}
}