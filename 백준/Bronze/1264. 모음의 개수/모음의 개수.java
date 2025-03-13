import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals("#")) {
			int count = 0;
			for(char c : s.toCharArray()) {
				c = Character.toLowerCase(c);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}