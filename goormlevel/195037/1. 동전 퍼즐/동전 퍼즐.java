import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.MAX_VALUE;
		String[] first = br.readLine().split(" ");
		int H1 = Integer.parseInt(first[0]);
		int W1 = Integer.parseInt(first[1]);
		char[][] map1 = new char[H1][W1];
		for(int i = 0; i < H1; i++) {
			String temp = br.readLine();
			map1[i] = temp.toCharArray();
		}
		String[] second = br.readLine().split(" ");
		int H2 = Integer.parseInt(second[0]);
		int W2 = Integer.parseInt(second[1]);
		char[][] map2 = new char[H2][W2];
		int count = 0;
		List<int[]> list = new ArrayList<>();
		for(int i = 0; i < H2; i++) {
			String temp = br.readLine();
			for(int j = 0; j < W2; j++) {
				map2[i][j] = temp.charAt(j);
				if(map2[i][j] == 'O') {
					list.add(new int[] {i, j});
					count++;
				}
			}
		}
		int m = H2 + 2 * H1;
		int n = W2 + 2 * W1;
		for(int i = 1; i < H1 + H2; i++){
			for(int j = 1; j < W1 + W2; j++){
				char[][] map3 = new char[m][n];
				int same = 0;
				for(int k = i; k < i + H1; k++){
					for(int l = j; l < j + W1; l++){
						map3[k][l] = map1[k-i][l-j];
					}
				}
				for(int[] p : list) {
					if(map3[H1+p[0]][W1+p[1]] == 'O') {
						same++;
					}
				}
				answer = Math.min(answer, count - same);
			}
		}
		System.out.println(answer);
	}
}