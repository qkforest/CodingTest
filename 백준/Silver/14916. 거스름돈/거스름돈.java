import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int five = N / 5;
		int answer = -1;
		while(five >= 0) {
			int count = five;
			int left = N - (5 * count);
		    if(left % 2 == 0) {
				count += (left / 2);
				answer = count;
				break;
			}
			five--;
		}
		System.out.print(answer);
	}
}