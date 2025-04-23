import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int answer = 0;
		br.readLine();
		String s = br.readLine();
		for(char c : s.toCharArray()) {
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				answer++;
			}
		}
		sb.append(answer);
        System.out.print(sb);
	}
}