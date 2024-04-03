import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            answer[i] = check(numbers[i]);
        }
        return answer;
    }
    public int check(long num) {
        String bin = Long.toBinaryString(num);
        int len = bin.length();
        int idx = 1;
        while(len > Math.pow(2, idx) - 1) {
            idx++;
        }
        int newLen = (int)(Math.pow(2, idx) - 1);
        for(int i = len + 1; i <= newLen; i++) {
            bin = '0' + bin;
        }
        if(dfs(bin)) {
        	return 1;
        }
        return 0;
    }
   private static boolean dfs(String number) {
		boolean valid = true;
		int mid = (number.length()-1) / 2;
		char root = number.charAt(mid);
		String left = number.substring(0, mid);
		String right = number.substring(mid+1, number.length());
		if(root == '0' && (left.charAt((left.length()-1)/2) == '1' || right.charAt((right.length()-1)/2)== '1')) {
			return false;
		}
		if(left.length() >= 3) {
			valid = dfs(left);
			if(valid) {
				valid = dfs(right);
			}
		}
		return valid;
   }
}