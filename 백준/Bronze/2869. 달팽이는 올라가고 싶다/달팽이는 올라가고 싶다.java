import java.io.*;import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		int days = (V - A) / (A - B);
		int left = (V - A) % (A - B);
		days++;
		if(left > 0) {
			days++;
		}
		System.out.print(days);
	}
}