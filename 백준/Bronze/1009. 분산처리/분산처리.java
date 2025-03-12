import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = 1;
			for(int j = 0; j < b; j++) {
				c = (c * a) % 10;
			}
			sb.append(c == 0 ? 10 : c ).append("\n");
		}
		System.out.print(sb);
	}	
}