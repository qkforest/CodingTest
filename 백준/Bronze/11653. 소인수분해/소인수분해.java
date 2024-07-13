import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 2; i <= n; i++) {
			while(n % i == 0) {
				System.out.println(i);
				n /= i;
			}
			if(i > n) {
				break;
			}
		}
	}
}