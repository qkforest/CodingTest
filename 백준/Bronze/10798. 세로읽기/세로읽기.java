import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[][] arr = new char[5][15];
		int max = 0;
		for(int i = 0; i < 5; i++) {
			String s = br.readLine();
			max = Math.max(max, s.length());
			for(int j = 0; j < s.length(); j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < 5; j++) {
				if(arr[j][i] != 0) {
					sb.append(arr[j][i]);
				}
			}
		}
		System.out.print(sb);
	}
}