import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals("0")) {
			int n = Integer.parseInt(s);
			sb.append( n * (n+1) / 2).append("\n");
		}
        System.out.print(sb);
	}
}