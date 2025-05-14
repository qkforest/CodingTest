import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.parseInt(br.readLine()) + 3;
		answer += Integer.parseInt(br.readLine());
        System.out.print(answer);
	}
}