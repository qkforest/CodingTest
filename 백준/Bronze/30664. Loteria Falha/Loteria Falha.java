import java.math.BigInteger;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals("0")) {
			BigInteger n = new BigInteger(s);
			if(n.mod(BigInteger.valueOf(42)).equals(BigInteger.valueOf(0))) {
				sb.append("PREMIADO");
			} else {
				sb.append("TENTE NOVAMENTE");
			}
			sb.append("\n");
		}
        System.out.print(sb);
	}
}