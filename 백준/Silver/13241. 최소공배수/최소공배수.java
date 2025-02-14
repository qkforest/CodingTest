import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long A = Long.parseLong(s[0]);
		long B = Long.parseLong(s[1]);
		System.out.print(A * B / GCD(A, B));
	}
	public static long GCD(long a, long b) {
		if(b == 0) {
			return a;
		}
		return GCD(b, a%b);
	}
}