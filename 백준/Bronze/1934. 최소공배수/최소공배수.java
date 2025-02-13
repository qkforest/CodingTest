import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			sb.append(A * B / GCD(A, B)).append("\n");
		}
		System.out.print(sb);
	}
	public static int GCD(int A, int B) {
		if(B == 0) {
			return A;
		}
		return GCD(B, A % B);
	}
}