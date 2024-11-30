import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		long count2 = 0;
		long count5 = 0;
		count2 = get(n, 2) - get(m, 2) - get(n-m, 2);
		count5 = get(n, 5) - get(m, 5) - get(n-m, 5);
		System.out.print(Math.min(count2, count5));
	}
	public static long get(int n, int k) {
		long c = 0;
		while(n >= k) {
			c += n / k;
			n /= k;
		}
		return c;
	}
}