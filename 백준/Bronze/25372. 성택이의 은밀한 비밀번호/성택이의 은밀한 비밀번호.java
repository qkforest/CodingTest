import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < N; i++) {
			int len = br.readLine().length();
			if(len >= 6 && len <= 9) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}