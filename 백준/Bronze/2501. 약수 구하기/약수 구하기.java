import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		int count = 0;
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) {
				count++;
				if(count == K) {
					answer = i;
					break;
				}
			}
		}
		System.out.print(answer);
	}
}