import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 8;
		int idx = 1;
		while(true) {
			if(N - Math.pow(2, idx) == 0) {
				answer += idx + 2;
				break;
			} else if(N - Math.pow(2, idx) < 0) {
				answer += idx + 1;
				break;
			}
			idx++;
		}
		System.out.print(answer);
	}
}