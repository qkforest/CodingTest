import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int answer = -1;
		if(A == B) {
			answer = 0;
		} else if(A > B) {
			answer = 1;
		}
        System.out.print(answer);
	}
}