import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		long answer = 0;
		for(String s : arr) {
			answer += Integer.parseInt(s) * 5;

		}
        System.out.print(answer);
	}
}