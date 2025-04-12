import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		long A = Long.parseLong(s[0]);
		long B = Long.parseLong(s[1]);
		sb.append(A*A - B*B);	
        System.out.print(sb);
	}
}