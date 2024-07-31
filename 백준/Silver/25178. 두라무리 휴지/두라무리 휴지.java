import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String A = br.readLine();
		String B = br.readLine();
		if(A.charAt(0) != B.charAt(0) || A.charAt(N-1) != B.charAt(N-1)) {
			System.out.print("NO");
		} else {
			char[] arrA = A.toCharArray();
			char[] arrB = B.toCharArray();
			Arrays.sort(arrA);
			Arrays.sort(arrB);
			if(!Arrays.equals(arrA, arrB)) {
				System.out.print("NO");
			} else {
				A = A.replaceAll("a", "").replaceAll("e", "").replaceAll("i", "").replaceAll("o", "").replaceAll("u", "");
				B = B.replaceAll("a", "").replaceAll("e", "").replaceAll("i", "").replaceAll("o", "").replaceAll("u", "");
				if(!A.equals(B)) {
					System.out.print("NO");
				}
				else {
					System.out.print("YES");
				}
			}
		}
	}
}