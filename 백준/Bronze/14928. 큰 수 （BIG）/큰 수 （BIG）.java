import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String N = br.readLine();
        long r = 0;
        for(int i =0; i < N.length(); i++){
            r = (r * 10 + (N.charAt(i) - '0')) % 20000303;
        }
        System.out.print(r);
	}
}