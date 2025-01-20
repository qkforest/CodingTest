import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while(!(str = br.readLine()).equals("0 0")) {
			String[] s = str.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			if(a % b == 0 && a != 0) {
				sb.append("multiple");
			} else if(b % a == 0 && b !=0) {
				sb.append("factor");
			} else {
				sb.append("neither");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}