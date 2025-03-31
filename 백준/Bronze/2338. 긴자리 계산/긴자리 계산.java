import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BigInteger A = new BigInteger(br.readLine());
		BigInteger B = new BigInteger(br.readLine()); 
		sb.append(A.add(B)).append("\n").append(A.subtract(B)).append("\n").append(A.multiply(B));
		System.out.print(sb);
	}
}