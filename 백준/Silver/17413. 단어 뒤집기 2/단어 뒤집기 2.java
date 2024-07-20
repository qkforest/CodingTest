import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		String temp = "";
		while(idx < str.length()) {
			if(str.charAt(idx) == '<') {
				if(temp.length() > 0) {
					sb.append(new StringBuilder(temp).reverse());
					temp = "";
				}
				while(str.charAt(idx) != '>') {
					temp += str.charAt(idx);
					idx++;
				}
				sb.append(temp).append(">");
				temp = "";
			}
			else if(str.charAt(idx) == ' ') {
				sb.append(new StringBuilder(temp).reverse()).append(" ");
				temp = "";
			}
			else {
				temp += str.charAt(idx);
			}
			idx++;
		}
		if(temp.length() > 0) {
			sb.append(new StringBuilder(temp).reverse());
		}
		System.out.print(sb);
	}
}