import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int C = Integer.parseInt(br.readLine());
		A += C / 60;
		B += C % 60;
		if(B >= 60) {
			A += B / 60;
			B %= 60;
		}
		
		A %= 24;
		System.out.print(A + " " + B);
	}
}