import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		if(A > B) {
			sb.append(">");
		} else if(A < B) {
			sb.append("<");
		} else {
			sb.append("==");
		}
		System.out.print(sb);
	}
}