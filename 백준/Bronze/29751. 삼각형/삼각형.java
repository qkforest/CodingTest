import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int W = Integer.parseInt(s[0]);
		int H = Integer.parseInt(s[1]);
		sb.append(W*H*0.5);
		System.out.print(sb);
	}
}