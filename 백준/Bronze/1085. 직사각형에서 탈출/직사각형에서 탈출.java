import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		int w = Integer.parseInt(s[2]);
		int h = Integer.parseInt(s[3]);
		int r = Math.min(x, w-x);
		int c = Math.min(y, h-y);
		System.out.print(Math.min(r, c));
	}
}