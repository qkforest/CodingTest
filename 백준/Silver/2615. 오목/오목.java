import java.io.*;
import java.util.*;

class Main {
	public static int[][] board = new int[19][19];
	public static int[] pos;
  	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int win = 0;
		pos = new int[2];
		for(int i = 0; i < 19; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(board[i][j] != 0) {
					if(check(i, j)) {
						win = board[i][j];
					}
				}
				if(win != 0) {
					break;
				}
			}
			if(win != 0) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(win).append("\n");
		if(win != 0) {
			for(int num : pos) {
				sb.append(num+1).append(" ");
			}
		}
		System.out.print(sb);
 	}
 	public static boolean check(int i, int j) {
 		int stone = board[i][j];
 		int idx = 1;
 		while(i+idx < 19 && stone == board[i+idx][j]) {
 			idx++;
 		}
 		int count = idx;
 		idx = 1;
 		while(i-idx >= 0 && stone == board[i-idx][j]) {
 			idx++;
 			count++;
 		}
 		if(count == 5) {
 			pos[0] = i;
 			pos[1] = j;
 			return true;
 		}
 		idx = 1;
 		while(j+idx < 19 && stone == board[i][j+idx]) {
 			idx++;
 		}
 		count = idx;
 		idx = 1;
 		while(j-idx >= 0 && stone == board[i][j-idx]) {
 			idx++;
 			count++;
 		}
 		if(count == 5) {
 			pos[0] = i;
 			pos[1] = j;
 			return true;
 		}
 		idx = 1;
 		while(i+idx < 19 &&  j+idx < 19 && stone == board[i+idx][j+idx]) {
 			idx++;
 		}
 		count = idx;
 		idx = 1;
 		while(i-idx >= 0 &&j-idx >= 0 && stone == board[i-idx][j-idx]) {
 			idx++;
 			count++;
 		}
 		if(count == 5) {
 			pos[0] = i;
 			pos[1] = j;
 			return true;
 		}
 		idx = 1;
 		while(i-idx >= 0 && j+idx < 19 && stone == board[i-idx][j+idx]) {
 			idx++;
 		}
 		count = idx;
 		idx = 1;
 		while(i+idx < 19 && j-idx >= 0 && stone == board[i+idx][j-idx]) {
 			idx++;
 			count++;
 		}
 		if(count == 5) {
 			pos[0] = i + 4;
 			pos[1] = j - 4;
 			return true;
 		}
 		return false;
 	}
}