import java.io.*;

class Main {
	public static int[] gates;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		gates = new int[G+1];
		for(int i = 1; i <= G; i++) {
			gates[i] = i;
		}
		int P = Integer.parseInt(br.readLine());
		int[] planes = new int[P];
		for(int i = 0; i < P; i++) {
			planes[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int gate : planes) {
			int v = find(gate);
			if(v == 0) {
				break;
			} else {
				answer++;
				gates[v] = gates[v-1];
				find(gate);
			}
			
		}
		System.out.print(answer);
	}
	
	public static int find(int g) {
		if(gates[g] == g) {
			return g;
		}
		return gates[g] = find(gates[g]);
	}
}