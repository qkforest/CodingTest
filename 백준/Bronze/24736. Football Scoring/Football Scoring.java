import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] score = {6, 3, 2, 1, 2};
		for(int i = 0; i < 2; i++) {
			String[] s = br.readLine().split(" ");
			int answer = 0;
			for(int j = 0; j < 5; j++) {
				answer += Integer.parseInt(s[j]) * score[j];
			}
			sb.append(answer).append(" ");
		}
        System.out.print(sb);
	}
}