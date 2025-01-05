import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			for(char c : s[1].toCharArray()) {
				for(int j = 0; j < r; j++) {
					sb.append(c);
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}