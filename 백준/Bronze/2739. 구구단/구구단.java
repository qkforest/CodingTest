import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 1; i <= 9; i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
		}
		System.out.print(sb);
	}
}