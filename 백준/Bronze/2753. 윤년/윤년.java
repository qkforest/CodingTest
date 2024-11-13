import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Y = Integer.parseInt(br.readLine());
		int answer = 0;
		if(Y % 4 == 0 && Y % 100 != 0) {
			answer = 1;
		} else if(Y % 400 == 0) {
			answer = 1;
		}
		System.out.print(answer);
	}
}