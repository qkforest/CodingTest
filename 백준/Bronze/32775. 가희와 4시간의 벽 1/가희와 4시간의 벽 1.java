import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int S = Integer.parseInt(br.readLine());
		int F = Integer.parseInt(br.readLine());
		if(S > F) {
			sb.append("flight");
		} else {
			sb.append("high speed rail");
		}
        System.out.print(sb);
	}
}