import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			answer += Integer.parseInt(br.readLine());
		}
        System.out.print(answer);
	}
}