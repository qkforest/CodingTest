import java.io.*;
import java.util.Arrays;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int[][] cost = new int[n+1][n+1];
		int[][] path = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], 10000*1000-1);
			cost[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			cost[temp[0]][temp[1]] = Math.min(cost[temp[0]][temp[1]], temp[2]);
			cost[temp[1]][temp[0]] = Math.min(cost[temp[1]][temp[0]], temp[2]);
			path[temp[0]][temp[1]] = temp[1];
	        path[temp[1]][temp[0]] = temp[0];
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(cost[i][j] > cost[i][k]+cost[k][j]){
                        cost[i][j] = cost[i][k]+cost[k][j];
                        path[i][j] = path[i][k];
                    }
				}
			}
		}
		
		for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) {
                    System.out.print("-" + " ");
                    continue;
                }
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
	}
}