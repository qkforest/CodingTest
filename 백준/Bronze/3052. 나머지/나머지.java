import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < 10; i++) {
			set.add(Integer.parseInt(br.readLine())%42);
		}
		System.out.print(set.size());
	}
}