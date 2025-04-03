import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = br.readLine()).equals("0 0")) {
			String[] s = str.split(" ");
			if(Integer.parseInt(s[0]) > Integer.parseInt(s[1])) {
				sb.append("Yes");
			} else {
				sb.append("No");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}