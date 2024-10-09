import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int L = Integer.parseInt(s[2]);
        long answer = 0;
        int[] trucks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int weight = 0;
        Queue<long[]> q = new LinkedList<>();
        for(int truck : trucks) {
        	while(!q.isEmpty() && weight+truck > L) {
        		long[] t = q.poll();
        		answer = Math.max(t[1] + w, answer);
        		weight -= t[0];
        	}
        	q.offer(new long[] {truck, answer});
    		weight += truck;
    		answer++;
        }
        while(!q.isEmpty()) {
    		long[] t = q.poll();
    		answer = Math.max(t[1] + w + 1, answer);
    		weight -= t[0];
    	}
        System.out.print(answer);
	}
}