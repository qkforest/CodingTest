import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		sb.append(N*M);
		System.out.print(sb) ;
	}
}