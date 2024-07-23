import java.io.*;
import java.math.*;

class Main {
	public static StringBuilder sb;
  	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		BigInteger K = new BigInteger("2").pow(N).subtract(new BigInteger("1"));
		sb.append(K).append("\n");
		if(N <= 20) {
			hanoi(N, 1, 2, 3);
		}
		System.out.print(sb);
 	}
  	public static void hanoi(int N, int start, int mid, int des) {
  		if(N == 1) {
  			sb.append(start).append(" ").append(des).append("\n");
  			return;
  		}
  		hanoi(N-1, start, des, mid);
  		sb.append(start).append(" ").append(des).append("\n");
  		hanoi(N-1, mid, start, des);
  	}
}