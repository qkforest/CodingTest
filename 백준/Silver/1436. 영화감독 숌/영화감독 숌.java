import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int a = 666;
		while(N > 0) {
			if(String.valueOf(a).contains("666")) {
				N--;
			}
			a++;
		}
		System.out.print(a-1);
	}
}