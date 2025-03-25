import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		BigInteger A = new BigInteger(s[0]);
		BigInteger B =  new BigInteger(s[1]);
		sb.append(A.divide(B)).append("\n").append(A.mod(B));
		System.out.print(sb);
	}
}