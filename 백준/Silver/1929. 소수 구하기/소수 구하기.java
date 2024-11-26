import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		StringBuilder sb = new StringBuilder();
		for(int i = M; i <= N; i++) {
			if(i == 1) {
				continue;
			}
			if(isPrime(i)) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);
	}
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}