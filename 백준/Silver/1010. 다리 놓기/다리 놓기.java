import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			if(N == 0 || M == 0) {
				sb.append(0);
			} else {
				BigInteger answer = new BigInteger("1");
				BigInteger div = new BigInteger("1");
				for(int j = 0; j < N; j++) {
					answer = answer.multiply(BigInteger.valueOf(M-j));
					div = div.multiply(BigInteger.valueOf(j+1));
				}
				sb.append(answer.divide(div));
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}