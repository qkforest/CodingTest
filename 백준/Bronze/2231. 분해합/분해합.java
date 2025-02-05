import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(char c : String.valueOf(i).toCharArray()) {
				temp += c - '0';
			}
			if(N == i+temp) {
				answer = i;
				break;
			}
		}
		System.out.print(answer);
	}
}