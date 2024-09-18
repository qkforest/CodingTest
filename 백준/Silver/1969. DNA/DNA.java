import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		String[] DNA = new String[N];
		char[] sub = {'A', 'C', 'G', 'T'};
		int[][] distances = new int[M][4];
		for(int i = 0; i < N; i++) {
			DNA[i] = br.readLine();
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				char c = DNA[i].charAt(j);
				for(int k = 0; k < 4; k++) {
					if(c == sub[k]) {
						distances[j][k]++;
						break;
					}
				}
			}
		}
		StringBuilder answer = new StringBuilder();
		int min = 0;
		for(int i = 0; i < M; i++) {
			int m = Integer.MAX_VALUE;
			char c = '\0';
			for(int j = 0; j < 4; j++) {
				int d = N - distances[i][j];
				if(d < m) {
					m = d;
					c = sub[j];
				}
			}
			min += m;
			answer.append(c);
		}
		System.out.println(answer);
		System.out.print(min);
	}
}