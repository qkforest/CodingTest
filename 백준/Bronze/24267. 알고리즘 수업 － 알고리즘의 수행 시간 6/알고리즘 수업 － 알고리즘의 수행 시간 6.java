import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long N = Long.parseLong(br.readLine());
		sb.append(N*(N-1)*(N-2)/6).append("\n").append(3);
		System.out.print(sb);
	}
}