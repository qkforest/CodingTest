import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		long sum = 0;
		for(String n : s) {
			sum += Math.pow(Integer.parseInt(n), 2);
		}
        System.out.print(sum%10);
	}
}