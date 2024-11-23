import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		BigInteger a = BigInteger.ONE;
		for(int i = 2; i <= N; i++) {
			 a = a.multiply(BigInteger.valueOf(i));
		}
		String num = a.toString();
		while(answer <= num.length()-1 && num.charAt(num.length()-1-answer) == '0') {
			answer++;
		}
		System.out.print(answer);
	}
}