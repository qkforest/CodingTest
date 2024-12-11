import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 1;
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		if(x > 0) {
			if(y < 0) {
				answer = 4;
			}
		} else {
			if(y > 0) {
				answer = 2; 
			} else {
				answer = 3;
			}
		}
		System.out.print(answer);
	}
}