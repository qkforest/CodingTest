import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int answer = 320;
		if(s[1].equals("0")) {
			int T = Integer.parseInt(s[0]);
			if(T < 12 || T > 16) {
				answer = 280;
			}
		} else {
			answer = 280;
		}
        System.out.print(answer);
	}
}