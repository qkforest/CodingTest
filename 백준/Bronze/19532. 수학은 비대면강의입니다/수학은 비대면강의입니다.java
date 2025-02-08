import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
		String[] s = br.readLine().split(" ");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		int d = Integer.parseInt(s[3]);
		int e = Integer.parseInt(s[4]);
		int f = Integer.parseInt(s[5]);
		int x = (c*e - b*f) / (e*a - d*b);
		int y = (d*c - a*f) / (d*b - a*e);
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
	}
}