import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		char answer = 'S'; 
		for(String s : arr) {
			if(s.equals("9")) {
				answer = 'F';
				break;
			}
		}
        System.out.print(answer);
	}
}