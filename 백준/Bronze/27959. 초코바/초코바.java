import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]) * 100;
		int M = Integer.parseInt(s[1]);
		StringBuilder sb = new StringBuilder();
		if(N / M > 0) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}
		System.out.print(sb);
	}
}