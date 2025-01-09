import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		int answer = 0;
		for(char c : s.toCharArray()) {
			int time = c - 'A';
			if(time >= 0 && time < 3) {
				answer += 3;
			} else if(time >= 3 && time < 6) {
				answer += 4;
			} else if(time >= 6 && time < 9) {
				answer += 5;
			} else if(time >= 9 && time < 12) {
				answer += 6;
			} else if(time >= 12 && time < 15) {
				answer += 7;
			} else if(time >= 15 && time < 19) {
				answer += 8;
			} else if(time >= 19 && time < 22) {
				answer += 9;
			} else {
				answer += 10;
			}
		}
		System.out.print(answer);
	}
}