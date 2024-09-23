import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int J = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		char[] jerseys = new char[J+1];
		boolean[] visited = new boolean[J+1];
 		for(int i = 1; i <= J; i++) {
			jerseys[i] = br.readLine().charAt(0);
		}
 		int answer = 0;
 		for(int i = 0; i < A; i++) {
			String[] s = br.readLine().split(" ");
			int idx = Integer.parseInt(s[1]);
			if(jerseys[idx] <= s[0].charAt(0) && !visited[idx]) {
				answer++;
				visited[idx] = true;
			}
 		}
 		System.out.print(answer);
 	}
}