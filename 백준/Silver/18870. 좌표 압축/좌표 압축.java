import java.io.*;
import java.util.*;
public class Main {
	public static int N;
	public static int[] arr, sortedArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sortedArr = arr.clone();
		Arrays.sort(sortedArr);
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for(int a : sortedArr) {
			if(!map.containsKey(a)) {
				map.put(a, count);
				count++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N-1; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.print(sb.append(map.get(arr[N-1])));
	}
}