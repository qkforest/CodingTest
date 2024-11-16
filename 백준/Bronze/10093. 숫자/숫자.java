import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long A = Math.min(Long.parseLong(s[0]), Long.parseLong(s[1]));
		long B = Math.max(Long.parseLong(s[0]), Long.parseLong(s[1]));
		StringBuilder sb = new StringBuilder();
		if(A == B) {
			sb.append(0);
		} else {
			sb.append(B - A - 1).append("\n");
			A++;
			while(A < B) {
				sb.append(A++).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.print(sb);
	}
}