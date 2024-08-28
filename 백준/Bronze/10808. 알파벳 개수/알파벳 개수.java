import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		int[] arr = new int[26];
		
		for(char c : S.toCharArray()) {
			arr[c-'a']++;
		}
		
		for(int n : arr) {
			System.out.print(n + " ");
		}
	}
}