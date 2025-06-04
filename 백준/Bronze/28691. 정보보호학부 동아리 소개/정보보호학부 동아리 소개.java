import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, String> map = new HashMap<>();
		map.put("M", "MatKor");
		map.put("W", "WiCys");
		map.put("C", "CyKor");
		map.put("A", "AlKor");
		map.put("$", "$clear");
        System.out.print(map.get(br.readLine()));
	}
}