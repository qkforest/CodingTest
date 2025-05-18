import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "wrong!";
		String[] s = br.readLine().split(" ");
		if(Integer.parseInt(s[0]) + Integer.parseInt(s[1]) == Integer.parseInt(s[2]) ) {
			answer = "correct!";
		}
        System.out.print(answer);
	}
}