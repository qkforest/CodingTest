import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append("비와이");
		int N = Integer.parseInt(s[0]);
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
		}
		System.out.print(sb);
	}
}