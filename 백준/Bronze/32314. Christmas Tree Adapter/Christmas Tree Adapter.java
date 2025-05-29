import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		int A = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int W = Integer.parseInt(s[0]);
		int V = Integer.parseInt(s[1]);
		if(A <= W/V) {
			answer = 1;
		}
        System.out.print(answer);
	}
}