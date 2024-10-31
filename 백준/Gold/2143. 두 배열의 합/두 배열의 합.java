import java.io.*;
import java.util.*;

class Main {
	public static int T, n, m;
	public static List<Long> listA, listB;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		int[] A  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		m = Integer.parseInt(br.readLine());
		int[] B  = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		listA = new ArrayList<>();
		listB = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			long sum = 0;
			for(int j = i; j < n; j++) {
				sum += A[j];
				listA.add(sum);
			}
		}
		
		for(int i = 0; i < m; i++) {
			long sum = 0;
			for(int j = i; j < m; j++) {
				sum += B[j];
				listB.add(sum);
			}
		}
		
		Collections.sort(listA);
		Collections.sort(listB, Collections.reverseOrder());
		
		n = listA.size();
		m = listB.size();
		
		int idxA = 0;
		int idxB = 0;
		long answer = 0;
		
		while(idxA < n && idxB < m) {
			long tempA = listA.get(idxA);
			long target = T - tempA;
			if(listB.get(idxB) == target) {
				long countA = 0;
				long countB = 0;
				while(idxA < n && listA.get(idxA) == tempA) {
					idxA++;
					countA++;
				}
				while(idxB < m && listB.get(idxB)== target) {
					idxB++;
					countB++;
				}
				answer += countA * countB;
			} else if(listB.get(idxB) < target) {
				idxA++;
			} else {
				idxB++;
			}
		}
		
		System.out.print(answer);
		
	}
}