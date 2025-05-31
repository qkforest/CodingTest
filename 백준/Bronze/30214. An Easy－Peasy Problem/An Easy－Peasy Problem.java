import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		float s1 = Integer.parseInt(s[0]);
		float s2 = Integer.parseInt(s[1]);
		if(s1 >= s2 / (float)2) {
			sb.append("E");
		} else {
			sb.append("H");
		}
        System.out.print(sb);
	}
}