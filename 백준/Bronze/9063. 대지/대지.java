import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x1 = 10000;
		int x2 = -10000;
		int y1 = 10000;
		int y2 = -10000;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			x1 = Math.min(x1, x);
			x2 = Math.max(x2, x);
			y1 = Math.min(y1, y);
			y2 = Math.max(y2, y);
		}
		System.out.print((x2-x1)*(y2-y1));
	}
}