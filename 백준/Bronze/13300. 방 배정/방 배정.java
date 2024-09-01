import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] count = new int[6][2];
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int S = Integer.parseInt(s[0]);
			int Y = Integer.parseInt(s[1])-1;
			count[Y][S]++;
		}
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				answer += count[i][j] / K;
				if(count[i][j] % K != 0) {
					answer++;
				}
			}
		}
		
		System.out.print(answer);
	}
}