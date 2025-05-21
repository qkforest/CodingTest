import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer = "Violet";
		int n = Integer.parseInt(br.readLine());
		if(n >= 620) {
			answer = "Red";
		} else if(n >= 590) {
			answer = "Orange";
		} else if(n >= 570) {
			answer = "Yellow";
		} else if(n >= 495) {
			answer = "Green";
		} else if(n >= 450) {
			answer = "Blue";
		} else if(n >= 425) {
			answer = "Indigo";
		}
        System.out.print(answer);
	}
}