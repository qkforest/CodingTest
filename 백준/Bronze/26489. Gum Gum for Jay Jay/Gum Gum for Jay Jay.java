import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int answer = 0;
		while((s=br.readLine()) != null) {
			answer++;
		}
        System.out.print(answer);
	}
}