import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[2001][26];
		for(int i = 1; i <= str.length(); i++) {
			for(int j = 0; j < 26; j++) {
				arr[i][j] = arr[i-1][j];
			}
			int idx = str.charAt(i-1) - 'a';
			arr[i][idx] = arr[i-1][idx] + 1;
		}
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int idx = s[0].charAt(0) - 'a';
			sb.append(arr[Integer.parseInt(s[2])+1][idx] - arr[Integer.parseInt(s[1])][idx]).append("\n");
		}
		System.out.print(sb);
	}
}