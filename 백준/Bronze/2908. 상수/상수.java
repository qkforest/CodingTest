import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringBuilder A = new StringBuilder(s[0]).reverse();
		StringBuilder B = new StringBuilder(s[1]).reverse();
		System.out.print(Math.max(Integer.parseInt(A.toString()), Integer.parseInt(B.toString())));
	}
}