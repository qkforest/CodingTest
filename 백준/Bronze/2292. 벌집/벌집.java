import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 1;
		int last = 1;
		if(N > 1) {
			while(last < N) {
				last += 6 * answer;
				answer++;
			}
		}
		System.out.print(answer);
	}
}