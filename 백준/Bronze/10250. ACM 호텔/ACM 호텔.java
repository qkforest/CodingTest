import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int H = Integer.parseInt(s[0]);
			int N = Integer.parseInt(s[2]);
			int answer = N % H;
			if(answer == 0) {
				answer = H;
			}
			sb.append(answer);
			answer = N % H == 0 ? 0 : 1;
			answer += N / H;
			if(answer < 10) {
				sb.append(0);
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
}