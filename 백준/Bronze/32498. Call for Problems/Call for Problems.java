import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i = 0; i < n; i++) {
			if( Integer.parseInt(br.readLine()) % 2 != 0) {
				answer++;
			}
		}
        System.out.print(answer);
	}
}