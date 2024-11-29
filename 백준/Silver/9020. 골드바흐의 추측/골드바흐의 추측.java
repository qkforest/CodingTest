import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			int A = n/2;
			if(A % 2 == 0) {
				A--;
			}
			boolean find = false;
			while(A > 1) {
				int B = n - A;
				if(isPrime(A) && isPrime(B)) {
					find = true;
					sb.append(A).append(" ").append(B).append("\n");
					break;
				}
				A -= 2;
			}
			if(!find) {
				if(isPrime(2) && isPrime(n-2)) {
					find = true;
					sb.append(2).append(" ").append(n-2).append("\n");
				}
			}
		}
		System.out.print(sb);
	}
	public static boolean isPrime(int num) {
		if(num == 1) {
			return false;
		}
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}