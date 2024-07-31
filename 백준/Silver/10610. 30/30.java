import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		int sum = 0;
		
		Arrays.sort(N);
        
		for(char c : N) {
			sum += c - '0'; 
		}
        
        StringBuilder sb = new StringBuilder();
        
        if(N[0] == '0' && sum % 3 == 0)  {
            for (int i = N.length-1; i >= 0; i--) {
            	sb.append(N[i]);
            }
        } else {
        	 sb.append(-1);
        }
        
        System.out.println(sb);
	}
}