import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] word1 = new int[26];
		int[] word2 = new int[26];
		
		count(word1, br.readLine());
		count(word2, br.readLine());
		
		int answer = 0;
		for(int i = 0; i < 26; i++) {
			answer += Math.abs(word1[i] - word2[i]);
		}
		
		System.out.print(answer);
	}
	
	public static void count(int[] arr, String str) {
		for(char c : str.toCharArray()) {
			arr[c-'a']++;
		}
	}
}