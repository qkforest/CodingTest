import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		sb.append(Integer.parseInt(s[0]) * Integer.parseInt(s[1]) - Integer.parseInt(s[2]) * Integer.parseInt(s[3]) * Integer.parseInt(s[4]));
        System.out.print(sb);
	}
}