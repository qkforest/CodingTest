import java.io.*;
import java.util.*;

class Main {
	public static boolean[] open;
	public static List<int[]> homes;
	public static List<int[]> chickens;
	public static int answer;
	public static int M;
  	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N  = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		answer = Integer.MAX_VALUE;
		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				if(s[j].equals("1")) {
					homes.add(new int[] {i, j});
				}
				else if(s[j].equals("2")) {
					chickens.add(new int[] {i, j});
				}
			}
		}
		open = new boolean[chickens.size()];
		for(int i = 1; i <= M; i++) {
			dfs(0 ,0, i);
		}
		System.out.print(answer);
  	}
  	public static void dfs(int level, int start, int remain) {
  		if(level == remain) {
  			int temp = 0;
  			for(int[] home : homes) {
  				int min = Integer.MAX_VALUE;
  				for(int i = 0; i < chickens.size(); i++) {
  					if(open[i]) {
  						int[] chicken = chickens.get(i);
  						min = Math.min(min, Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]));
  					}
  				}
  				temp += min;
  			}
  			answer = Math.min(answer, temp);
  		}
  		for(int i = start; i < chickens.size(); i++) {
  			open[i] = true;
  			dfs(level+1, i + 1, remain);
  			open[i] = false;
  		}
  	}
}