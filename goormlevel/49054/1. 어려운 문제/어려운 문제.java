import java.io.*;
import java.math.BigInteger;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		BigInteger[] fac = new BigInteger[n+1];
		fac[0] =  BigInteger.valueOf(1);
		for(int i = 1; i <= n; i++) {
			fac[i] =  BigInteger.valueOf(i).multiply(fac[i-1]);
		}
		BigInteger result = fac[n];
		while(String.valueOf(result).length() > 1) {
			result = BigInteger.valueOf(checkSum(String.valueOf(result)));
		}
		System.out.println(result);
	}
	public static long checkSum(String s){
		int sum = 0;
		for(char c : s.toCharArray()) {
			sum += c - '0'; 
		}
		return sum;
	}
}