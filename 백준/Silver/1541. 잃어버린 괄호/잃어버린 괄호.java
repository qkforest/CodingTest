import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("-");
		for(int i = 0; i < s.length; i++) {
			if(s[i].contains("+")) {
				String[] temp = s[i].split("\\+");
				int sum = 0;
				for(String t : temp) {
					sum += Integer.parseInt(t);
				}
				s[i] = String.valueOf(sum);
			} 
		}
		int answer =Integer.parseInt(s[0]);
		for(int i = 1; i < s.length; i++) {
			answer -= Integer.parseInt(s[i]);
		}
		System.out.print(answer);
	}
}