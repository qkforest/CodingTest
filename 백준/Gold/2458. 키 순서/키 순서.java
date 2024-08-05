import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		boolean[][] compare = new boolean[N][N];
		int answer = 0;
	
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			compare[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = true;
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(compare[i][k] && compare[k][j]) {
						compare[i][j] = true;
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			int count = 0;
			for(int j = 0; j < N; j++) {
				if(compare[i][j] || compare[j][i]) {
					count++;
				}
			}
			if(count == N-1) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}