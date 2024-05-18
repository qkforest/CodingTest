import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		List<List<Integer>> multiverse = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			s = br.readLine().split(" ");
			Set<Integer> set = new TreeSet<>();
			List<Integer> universe = new ArrayList<>();
			for(int j = 0; j < N ; j++) {
				int planet = Integer.parseInt(s[j]);
				universe.add(planet);
				set.add(planet);
			}
			List<Integer> order = new ArrayList<>(set);
			for(int j = 0; j < N ; j++) {
				universe.set(j, Collections.binarySearch(order,universe.get(j)));
			}
			multiverse.add(universe);
		}
		int answer = 0;
		for(int i = 0; i < M; i++) {
			for(int j = i+1; j < M; j++) {
				if(Arrays.equals(multiverse.get(i).toArray(), multiverse.get(j).toArray())) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}