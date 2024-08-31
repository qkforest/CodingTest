import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			String[] words = br.readLine().split(" ");
			char[] a = words[0].toCharArray();
			char[] b = words[1].toCharArray();
			Arrays.sort(a);
			Arrays.sort(b);
			if(new String(a).endsWith(new String(b))) {
				sb.append("Possible");
			} else {
				sb.append("Impossible");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}