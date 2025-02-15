import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			long n = Long.parseLong(br.readLine());
			while(true) {
				if(isPrime(n)) {
					sb.append(n).append("\n");
					break;
				} else {
					n++;
				}
			}
		}
		System.out.print(sb);
	}
	public static boolean isPrime(long n) {
		if(n < 2) {
			return false;
		}
		for(long i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}