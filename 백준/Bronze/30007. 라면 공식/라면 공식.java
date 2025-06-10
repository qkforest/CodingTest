import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0;  i< N; i++) {
			String[] s = br.readLine().split(" ");
			sb.append(Integer.parseInt(s[0]) * (Integer.parseInt(s[2]) - 1) + Integer.parseInt(s[1])).append("\n");
		}
        System.out.print(sb);
	}
}