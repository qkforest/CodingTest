import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] cost = {3, 4, 5};
		int answer = 0;
		for(int i = 0; i < 3; i++) {
			answer += Integer.parseInt(br.readLine()) * cost[i];
		}
        System.out.print(answer);
	}
}