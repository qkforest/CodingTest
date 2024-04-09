import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] dp = new int[1001][1001];
		int minX = 1001;
		int maxX = 0;
		int minY = 1001;
		int maxY = 0;
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			int x1 = Integer.parseInt(temp[0]);
			int y1 = Integer.parseInt(temp[1]);
			int x2 = Integer.parseInt(temp[2]);
			int y2 = Integer.parseInt(temp[3]);
			minX = Math.min(minX, x1);
			maxX = Math.max(maxX, x2);
			minY = Math.min(minY, y1);
			maxY = Math.max(maxY, y2);
			dp[y1][x1]++;
			dp[y2][x2]++;
			dp[y1][x2]--;
			dp[y2][x1]--;
		}
		
		for(int i = minY; i < maxY; i++) {
			for(int j = minX; j < maxX; j++) {
				dp[i][j + 1] += dp[i][j];
			}
		}
		for(int j = minX; j < maxX; j++) {
			for(int i = minY; i < maxY; i++) { 
				dp[i + 1][j] += dp[i][j];
			}
		}
		for(int i = minY; i < maxY; i++) {
			for(int j = minX; j < maxX; j++) {
				if(dp[i][j] == K) {
					answer++;
				}
			}
		}
		
		System.out.print(answer);
	}
}