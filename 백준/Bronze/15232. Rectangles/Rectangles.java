import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i < R; i++) {
			sb.append("*".repeat(C)).append("\n");
		}
        System.out.print(sb);
	}
}