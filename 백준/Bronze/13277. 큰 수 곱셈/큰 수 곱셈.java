import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		BigInteger A = new BigInteger(s[0]);
		BigInteger B =  new BigInteger(s[1]);
		System.out.print(B.multiply(A));
	}
}