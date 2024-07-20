import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		StringBuilder temp  = new StringBuilder();
		while(idx < str.length()) {
			if(str.charAt(idx) == '<') {
				if(temp.length() > 0) {
					sb.append(temp.reverse());
					temp.setLength(0);
				}
				while(str.charAt(idx) != '>') {
					temp.append(str.charAt(idx));
					idx++;
				}
				sb.append(temp).append(">");
				temp.setLength(0);
			}
			else if(str.charAt(idx) == ' ') {
				sb.append(temp.reverse()).append(" ");
				temp.setLength(0);
			}
			else {
				temp.append(str.charAt(idx));
			}
			idx++;
		}
		if(temp.length() > 0) {
			sb.append(temp.reverse());
		}
		System.out.print(sb);
	}
}