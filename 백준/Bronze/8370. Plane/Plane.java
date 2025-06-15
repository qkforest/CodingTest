import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
        System.out.print(Integer.parseInt(s[0]) * Integer.parseInt(s[1]) + Integer.parseInt(s[2]) * Integer.parseInt(s[3]));
	}
}