import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int x = 0;
		int y = 0;
		String[] s = br.readLine().split(" ");
		int x1 = Integer.parseInt(s[0]);
		int y1 = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int x2 = Integer.parseInt(s[0]);
		int y2 = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int x3 = Integer.parseInt(s[0]);
		int y3 = Integer.parseInt(s[1]);
		if(x1 == x2) {
			x = x3;
		} else if(x2 == x3) {
			x = x1;
		} else {
			x = x2;
		}
		if(y1 == y2) {
			y = y3;
		} else if(y2 == y3) {
			y = y1;
		} else {
			y = y2;
		}
		sb.append(x).append(" ").append(y);
		System.out.print(sb);
	}
}