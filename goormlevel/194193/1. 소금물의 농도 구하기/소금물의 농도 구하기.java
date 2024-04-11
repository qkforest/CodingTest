import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		double num = (0.7 * N)/(N+M) * 10;
		double answer = Math.floor(num * 100) / 100;
		System.out.printf("%.2f", answer);
	}
}