import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int a1 = Integer.parseInt(s[0]);
		int a2 = Integer.parseInt(s[1]);
		int c = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int answer = 1;
		for(int i = n; i <= 100; i++) {
			if(a1 * i + a2 > c * i) {
				answer = 0;
				break;
			}
		}
		System.out.print(answer);
	}
}