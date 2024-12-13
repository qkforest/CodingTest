import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int H = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		if(M < 45) {
			M += (60 - 45);
			H--;
			if(H < 0) {
				H += 24;
			}
		} else {
			M -= 45;
		}
		System.out.print(H + " " + M);
	}
}