import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		for(char c : s.toCharArray()) {
			if(c >= 'a'- 0 && c <= 'z') {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toLowerCase(c));
			}
		}
		System.out.print(sb);
	}
}