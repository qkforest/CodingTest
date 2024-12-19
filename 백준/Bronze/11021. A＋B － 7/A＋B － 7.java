import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			String[] s = br.readLine().split(" ");
			
			sb.append("Case #").append(i).append(": ").append(Integer.parseInt(s[0])+Integer.parseInt(s[1])).append("\n");
		}
		System.out.print(sb);
	}
}