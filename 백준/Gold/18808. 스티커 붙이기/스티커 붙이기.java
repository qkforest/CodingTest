import java.io.*;
import java.util.*;

class Main {
	public static int N, M, K;
	public static int[][] board;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		
		board = new int[N][M];
		
		int answer = 0;
		
		for(int i = 0; i < K; i++) {
			s = br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			int[][] sticker = new int[r][c];
			for(int j = 0; j < r; j++) {
				s = br.readLine().split(" ");
				for(int l = 0; l < c; l++) {
					sticker[j][l] = Integer.parseInt(s[l]);
				}
			}
			answer += attach(sticker);
		}
		System.out.print(answer);
	}
	
	public static int attach(int[][] sticker) {
		int count = 0;
		int degree = 0;
		while(degree <= 270) {
			int[][] rotate = rotate(sticker, degree);
			int r = rotate.length;
			int c = rotate[0].length;
			for(int i = 0; i <= N - r; i++) {
				for(int j = 0; j <= M - c; j++) {
					boolean vaild = true;
					for(int k = 0; k < r; k++) {
						for(int l = 0; l < c; l++) {
							if(board[i+k][j+l] == 1 && rotate[k][l] == 1) {
								vaild = false;
								break;
							}
						}
						if(!vaild) {
							break;
						}
					}
					if(vaild) {
						for(int k = 0; k < r; k++) {
							for(int l = 0; l < c; l++) {
								if(rotate[k][l] == 1) {
									count++;
									board[i+k][j+l] = 1;
								}
							}
						}
						return count;
					}
				}
			}
			degree += 90;
		}
		return count;
	}
	public static int[][] rotate(int[][] sticker, int degree) {
		if(degree == 0) {
			return sticker;
		}
		int[][] rotate;
	    int r = sticker.length;
	    int c = sticker[0].length;
	    switch(degree) {
	    	case 90 : 
	    		rotate = new int[c][r];
	    		break;
	    	case 180 : 
	    		rotate = new int[r][c];
	    		break;
	    	case 270 : 
	    		rotate = new int[c][r];
	    		break;
	    	default:
	            throw new IllegalArgumentException();
	    }
	    
	    for (int i = 0; i < rotate.length; i++) {
	        for (int j = 0; j < rotate[i].length; j++) {
	            switch (degree) {
	                case 90:
	                    rotate[i][j] = sticker[r-1-j][i];
	                    break;
	                case 180:
	                    rotate[i][j] = sticker[r-1-i][c-1-j];
	                    break;
	                case 270:
	                    rotate[i][j] = sticker[j][c-1-i];
	            }
	        }
	    }
	    
	    return rotate;
	}
}