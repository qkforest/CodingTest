import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Math.min(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		int B = Math.max(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		StringBuilder sb = new StringBuilder();
		if(A == B) {
			sb.append(0);
		} else {
			sb.append(B - A - 1).append("\n");
			for(int i = A+1; i < B; i++) {
			sb.append(i).append(" ");
			}
			sb.deleteCharAt(sb.length()-1);
		}
		System.out.print(sb);
	}
}