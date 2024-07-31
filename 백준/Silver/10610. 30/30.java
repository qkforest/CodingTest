import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int arr[] = new int[N.length()];
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            arr[i] = N.charAt(i) - '0';
            sum += N.charAt(i) - '0';
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        if (arr[0] == 0 && sum % 3 == 0)  {
            for (int i = N.length()-1; i >= 0; i--) {
            	sb.append(arr[i]);
            }
        } else {
        	 sb.append(-1);
        }
        System.out.println(sb);
	}
}