import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int B = Integer.parseInt(br.readLine());
        System.out.print(B/11*10);
	}
}