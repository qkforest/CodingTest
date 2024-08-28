import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int[] arr = new int[26];
		
		for(char c : S.toCharArray()) {
			arr[c-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		
		System.out.print(sb);
	}
}