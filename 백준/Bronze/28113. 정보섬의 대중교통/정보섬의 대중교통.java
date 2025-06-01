import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[1]);
		int B = Integer.parseInt(s[2]);
		if(A < B) {
			sb.append("Bus");
		} else if(A == B) {
			sb.append("Anything");
		} else {
			sb.append("Subway");
		}
        System.out.print(sb);
	}
}