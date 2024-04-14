import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxDigit = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] maxNum = new int[maxDigit];
		int[] num = new int[maxDigit];
		String b = "";
		for(int i = 0; i < maxDigit; i++) {
			maxNum[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		for(int i = 0; i < s.length; i++) {
			num[maxDigit-s.length+i] = Integer.parseInt(s[i]);
		}
		int add = Integer.parseInt(br.readLine());
		for(int i = maxDigit-1; i >= 0; i--){
			int sum = num[i]+add;
			num[i] = sum % (maxNum[i]+1);
			add = sum / (maxNum[i]+1);
		}
		String answer = "";
		for(int n : num) {
			answer += String.valueOf(n);
		}
		System.out.println(answer);
	}
}