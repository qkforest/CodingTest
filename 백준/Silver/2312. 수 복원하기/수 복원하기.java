import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcases = Integer.parseInt(br.readLine());
		for(int t = 0; t < testcases; t++) {
			int n = Integer.parseInt(br.readLine());
			for(int d = 2; d <= n; d++) {
				if(n % d == 0 && isPrime(d)) {
					int count = 0;
					while(n % d == 0) {
						n /= d;
						count++;
					}
					sb.append(d).append(" ").append(count).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}