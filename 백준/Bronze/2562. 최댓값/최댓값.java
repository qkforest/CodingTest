import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int idx = 0;
		for(int i = 0; i < 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > max) {
				max = n;
				idx = i+1;
			}
		}
		System.out.print(max + "\n" + idx);
	}
}