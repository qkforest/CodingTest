import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		double A = Double.parseDouble(s[0]);
		double B = Double.parseDouble(s[1]);
		System.out.print(A/B);
	}
}