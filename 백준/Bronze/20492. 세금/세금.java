import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int t = N / 100 * 22;
		sb.append(N-t).append(" ").append(N-(t*2/10));
		System.out.print(sb);
	}
}