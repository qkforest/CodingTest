import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 1;
		int[] arr = new int[10];
		
		for(int i = 0; i < 3; i++) {
			result *= Integer.parseInt(br.readLine());
		}
		
		for(char c : String.valueOf(result).toCharArray()) {
			arr[c-'0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.print(sb);
	}
}