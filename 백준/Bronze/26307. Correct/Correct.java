import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int answer = (Integer.parseInt(s[0]) - 9) * 60;
		answer += Integer.parseInt(s[1]);
        System.out.print(answer);
	}
}