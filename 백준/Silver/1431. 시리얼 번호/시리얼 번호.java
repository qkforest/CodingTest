import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i= 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
            	if(o1.length() == o2.length()) {
            		int sum1 = 0;
            		int sum2 = 0;
            		for (int i = 0; i < o1.length(); i++) {
                        int n1 = o1.charAt(i) - '0';
                        int n2 = o2.charAt(i) - '0';
                        if (n1 > 0 && n1 < 10) {
                        	sum1 += n1;
                        }
                        if (n2 > 0 && n2 < 10) {
                            sum2 += n2;
                        }
                    }
                	if(sum1 == sum2) {
                		return o1.compareToIgnoreCase(o2);
                	}
                	return sum1 - sum2;
            	}
            	return o1.length() - o2.length();
            }
		});
		for(String s : arr) {
			sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
}