import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int C = Integer.parseInt(s[0]);
		int D = Integer.parseInt(s[1]);
		int gcd = GCD(B, D);
		int deno = (B * D) / gcd;
		A *= (deno / B);
		C *= (deno / D);
		int num = A+C;
		gcd = GCD(deno, num);
		sb.append(num/gcd).append(" ").append(deno/gcd).append("\n");
		System.out.print(sb);
		
	}
	public static int GCD(int a, int b) {
		if(a % b == 0) {
			return b;
		}
		return GCD(b, a % b);
	}
}