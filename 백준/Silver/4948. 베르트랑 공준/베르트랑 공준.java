import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int c = 123456;
		int[] count = new int[c*2];
		count[0] = 0;
		for(int i = 1; i < c*2; i++) {
			count[i] = count[i-1];
			if(isPrime(i+1)) {
				count[i]++;
			}
		}
		String s;
		while(!(s= br.readLine()).equals("0")) {
			int n = Integer.parseInt(s);
			sb.append(count[2*n-1] - count[n-1]).append("\n");
		}
		
		System.out.print(sb);
	}
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;	
	}
}