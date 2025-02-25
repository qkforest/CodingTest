import java.util.*;
import java.io.*;
import java.math.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		List<BigInteger> A = new ArrayList<>();
		BigInteger g = BigInteger.valueOf(1);
		BigInteger d = new BigInteger (s[0]);
		for(int i = 0; i < c; i++) {
			BigInteger a = new BigInteger(s[i]);
			A.add(a);
			d = gcd(g, a);
			g = g.multiply(a).divide(d);

		}
		if(A.contains(g)) {
			Collections.sort(A);
			g = g.multiply(A.get(0));
		}
		System.out.print(g);
	}
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		if(b == BigInteger.valueOf(0)) {
			return a;
		}
		return gcd(b, a.mod(b));
	}
}