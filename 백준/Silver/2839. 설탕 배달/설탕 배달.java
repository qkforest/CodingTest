import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		while(N >= 3 && N % 5 != 0) {
			N -= 3;
			answer++;
		}
		if(N % 5 == 0) {
			answer += (N / 5);
			N = 0;
		}
		if(N != 0) {
			answer = -1;
		}
		System.out.println(answer);
	}
}
