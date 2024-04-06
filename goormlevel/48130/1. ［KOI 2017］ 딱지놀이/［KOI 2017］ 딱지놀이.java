import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int turn = Integer.parseInt(br.readLine());
		String[] cards = {"4", "3", "2", "1"};
		for(int i = 0; i < turn; i++) {
			String[] A = br.readLine().split(" ");
			String[] B = br.readLine().split(" ");
			Map<String, Integer> mapA = new HashMap<>();
			Map<String, Integer> mapB = new HashMap<>();
			for(int j = 1; j < A.length; j++) {
				String c = A[j];
				if(mapA.containsKey(c)) {
					mapA.put(c, mapA.get(c)+1);
				}
				else {
					mapA.put(c, 1);
				}
			}
			for(int j = 1; j < B.length; j++) {
				String c = B[j];
				if(mapB.containsKey(c)) {
					mapB.put(c, mapB.get(c)+1);
				}
				else {
					mapB.put(c, 1);
				}
			}
			for(int j = 0; j < 4; j++){
				int ACnt = 0;
				int BCnt = 0;
				String card = cards[j];
				if(mapA.containsKey(card)) {
					ACnt = mapA.get(card);
				}
				if(mapB.containsKey(card)){
					BCnt = mapB.get(card);
				}
				if(ACnt != BCnt){
					if(ACnt > BCnt){
						System.out.println("A");
					}
					else {
						System.out.println("B");
					}
					break;
				}
				else if(j == 3) {
					System.out.println("D");
				}
			}
		}
		System.out.println("");
	}
}