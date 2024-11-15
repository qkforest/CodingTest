import java.io.*;
import java.util.*;
class Main {
	public static int[] cards;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		cards = new int[20];
		for(int i = 0; i < 20; i++) {
			cards[i] = i+1;
		}
		for(int i = 0; i < 10; i++) {
			String[] s = br.readLine().split(" ");
			int left = Integer.parseInt(s[0]) - 1;
			int right = Integer.parseInt(s[1]) - 1;
			while(left < right) {
				swap(left, right);
				left++;
				right--;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int n : cards) {
			sb.append(n).append(" ");
		}
		System.out.print(sb);
	}
	public static void swap(int left, int right) {
		int temp = cards[left];
		cards[left] = cards[right];
		cards[right] = temp;
	}
}