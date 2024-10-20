import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			sb.append(Integer.parseInt(s[0])+Integer.parseInt(s[1])).append("\n");
		}
		System.out.print(sb);
	}
}