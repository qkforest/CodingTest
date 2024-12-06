import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		System.out.print(Long.parseLong(s[0])+Long.parseLong(s[1])+Long.parseLong(s[2]));
	}
}