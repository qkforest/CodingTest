import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int answer = 0;
		if(N.charAt(0) == N.charAt(1)) {
			answer = 1;
		}
        System.out.print(answer);
	}
}