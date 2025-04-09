import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] w = new int[3];
		for(int i = 0; i < 3; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(w);
        System.out.print(w[1]);
	}
}