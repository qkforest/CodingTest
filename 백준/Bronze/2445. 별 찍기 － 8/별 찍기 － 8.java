import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 1; i <= N  ; i++) {
        	StringBuilder temp = new StringBuilder();
        	StringBuilder str = new StringBuilder();
            for(int j = 0; j < i; j++){
            	str.append("*");
            }
            temp.append(str);
            for(int j = 0; j < 2 * N - (2 * i); j++) {
                temp.append(" ");
            }
            temp.append(str);
            stack.push(temp.toString());
            sb.append(temp).append("\n");
        }
        stack.pop();
        while(!stack.isEmpty()) {
        	sb.append(stack.pop()).append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length()-1));
	}
}