import java.io.*;
import java.math.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		BigInteger[] fac = new BigInteger[N+1];
		fac[0] = BigInteger.valueOf(1);
		for(int i = 1; i <= N; i++) {
			fac[i] = fac[i-1].multiply(BigInteger.valueOf(i));
		}
		System.out.print(fac[N]);
	}
}