import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int J = Integer.parseInt(s[1]);
		int H = Integer.parseInt(s[2]);
		int round = 0;
		while(J != H) {
			J -= J / 2;
			H -= H / 2;
			round++;
		}
		System.out.print(round);
	}
}