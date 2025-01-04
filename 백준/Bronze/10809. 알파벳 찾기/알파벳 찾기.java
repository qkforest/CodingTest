import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String s = br.readLine();
		int[] arr = new int[26];
		for(int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i)-'a';
			if(arr[idx] == 0) {
				arr[idx] = i+1;
			}
		}
		for(int n : arr) {
			sb.append(n-1).append(" ");
		}
		System.out.print(sb);
	}
}