import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < N; i++) {
	        String file = br.readLine(); 
	        map.merge(file.substring(file.lastIndexOf(".")+1, file.length()), 1, Integer::sum);
         }
		
		StringBuilder sb = new StringBuilder();
		
		for(String name : map.keySet()) {
			sb.append(name).append(" ").append(map.get(name)).append("\n");
		}
		
		System.out.print(sb);
	}
}