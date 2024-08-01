import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		int[][] classes = new int[N+1][5];
		for(int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < 5; j++) {
				classes[i][j] = Integer.parseInt(s[j]);
			}
			
		}
		int idx = 1;
		int max = 0;
		for(int i = 1; i <= N; i++) {
			int count = 0;
			boolean[] visited = new boolean[N+1];
 			for(int j = 1; j <= N ; j++) {
				if(i == j) {
					continue;
				}
				for(int c = 0; c < 5; c++) {
					if(classes[i][c] == classes[j][c] && !visited[j]) {
						visited[j] = true;
						count++;
						break;
					}
				}
			}
			if(max < count) {
				max = count;
				idx = i;
			}
		}
		System.out.print(idx);
	}
}