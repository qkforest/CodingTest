import java.io.*;
import java.util.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] solutions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		System.out.println(binarySearch(solutions, N));
	}
	public static int binarySearch(int[] solutions, int N) {
		int answer = -1;
		int min = 2000000000;
		int left = 0;
		int right = N-1;
		while(left < right) {
			int sum = solutions[left] + solutions[right];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				answer = sum;
			}
			if(sum > 0) {
				right--;
			} else {
				left++;
			}
			
		}
		return answer;
	}
}