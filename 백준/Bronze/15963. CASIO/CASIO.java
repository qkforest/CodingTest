import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringBuilder sb = new StringBuilder();
		if(s[0].equals(s[1])) {
			sb.append(1);
		} else {
			sb.append(0);
		}
		System.out.print(sb);
	}
}