import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(Integer.parseInt(br.readLine())*1000 + Integer.parseInt(br.readLine())*10000);
	}
}