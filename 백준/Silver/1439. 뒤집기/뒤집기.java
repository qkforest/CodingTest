import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int countZero = 0;
		int countOne = 0;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(i-1)) {
				if(s.charAt(i-1) == '0') {
					countZero++;
				}
				else {
					countOne++;
				}
			}
		}
		System.out.println(Math.max(countZero, countOne));
	}
}