import java.util.*;
import java.io.*;
class Main {
	public static int answer, K;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		answer = -1;
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		merge_sort(A, 0, N-1);
		System.out.print(answer);
	}
	public static void merge_sort(int[] A, int p, int r) {
		if(p < r) {
			int q = (p+r) / 2;
			merge_sort(A, p, q);
			merge_sort(A, q+1, r);
			merge(A, p, q, r);
		}
	}
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;
		int[] temp = new int[r - p + 1];
		while(i <= q && j <= r) {
			if(A[i] <= A[j]) {
				temp[t++] = A[i++];
			} else {
				temp[t++] = A[j++];
			}
		}
		while(i <= q) {
			temp[t++] = A[i++];
		}
		while(j <= r) {
			temp[t++] = A[j++]; 
		}
		i = p;
		t = 0;
		while(i <= r) {
			K--;
			if(K == 0) {
				answer = temp[t];
			}
			A[i++] = temp[t++];
		}
	}
}