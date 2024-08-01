import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> counts = new TreeMap<>();
		int[] arr = new int[N];
		double avg = 0;
		for(int i = 0 ; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			counts.merge(num, 1, Integer::sum);
			avg += num;
		}
		Arrays.sort(arr);
		List<Integer> keySet = new ArrayList<>(counts.keySet());
		keySet.sort((a, b) -> counts.get(b) - counts.get(a));
		int mode = keySet.get(0);
		int count = counts.get(keySet.get(0));
		if(keySet.size() > 1 && counts.get(keySet.get(1)) == count) {
			mode = keySet.get(1);
		}
		int mid = N/2;
		StringBuilder sb = new StringBuilder();
		sb.append(Math.round(avg/(double)N)).append("\n");
		sb.append(arr[mid]).append("\n");
		sb.append(mode).append("\n");
		sb.append(arr[N-1] - arr[0]);
		
		System.out.print(sb);
	}
}