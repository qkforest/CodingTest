import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = (Integer.parseInt(br.readLine()) - 1) * 7; 
		int Y = 2024;
		int M = N + 8;
		Y += M / 12;
		M %= 12;
		if(M == 0) {
			Y--;
			M = 12;
		}
		sb.append(Y).append(" ").append(M);
		System.out.print(sb);
	}
}