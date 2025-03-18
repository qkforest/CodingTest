import java.util.*;
import java.io.*;
class Main {
	public static int N, num, min;
	public static int[] t1, sum;
	public static int[][] p;
	public static StringBuilder sb;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = N/2;
		t1 = new int[num];
		sum = new int[N];
		for(int i = 0; i < N; i++) {
			sum[i] = i;
		}
		p = new int[N][N];
		min = Integer.MAX_VALUE;
		sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				p[i][j] = Integer.parseInt(s[j]);
			}
		}
		find(0, 0);
		System.out.print(min);
	}
	public static void find(int level, int start) {
		if(level == num) {
			int s1 = 0;
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					s1 += p[t1[i]][t1[j]];
				}
			}
			int[] t2 = Arrays.stream(sum)
			        .filter(x -> Arrays.stream(t1).noneMatch(y -> y == x))
			        .toArray();
			int s2 = 0;
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					s2 += p[t2[i]][t2[j]];
				}
			}
			min = Math.min(min, Math.abs(s1-s2));
			return;
		}
		for(int i = start; i < N; i++) {
			t1[level] = i;
			find(level+1, i+1);
		}
	}
}