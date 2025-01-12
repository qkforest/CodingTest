import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int left = 0;
		int right = arr.length - 1;
		int answer = 1;
		while(left <= right) {
			if(arr[left] != arr[right]) {
				answer = 0;
				break;
			}
			left++;
			right--;
		}
		System.out.print(answer);
	}
}