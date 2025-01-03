import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		String num = br.readLine();
		long answer = 0;
		for(int i = 0; i < N; i++) {
			answer += num.charAt(i) - '0';
		}
		System.out.print(answer);
	}
}