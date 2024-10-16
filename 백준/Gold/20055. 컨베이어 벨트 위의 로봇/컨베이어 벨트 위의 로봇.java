import java.io.*;
import java.util.*;

class Main {
	public static LinkedList<Box> belts; 
	public static int N, K;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		K = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		belts = new LinkedList<>();
		for(int i = 0; i < 2*N; i++) {
			belts.add(new Box(Integer.parseInt(s[i]), false));
		}
		int answer = 0;
		while(K > 0) {
			answer++;
			rotate();
			move();
			if(belts.get(0).value > 0 && !belts.get(0).robot) {
				belts.get(0).value--;
				belts.get(0).robot = true;
				if(belts.get(0).value == 0) {
					K--;
				}
			}
		}
		System.out.print(answer);
	}
	public static void rotate() {
		belts.add(0, belts.removeLast());
		if(belts.get(N-1).robot) {
			belts.get(N-1).robot = false;
		}
	}
	public static void move() {
		for(int i = N-2; i >= 0; i--) {
			if(belts.get(i).robot) {
				Box next = belts.get(i+1); 
				if(!next.robot && next.value > 0) {
					next.robot = true;
					next.value--;
					if(next.value == 0) {
						K--;
					}
					belts.get(i).robot = false;
				}
			}
			if(belts.get(N-1).robot) {
				belts.get(N-1).robot = false;
			}
		}
	}
	public static class Box {
		int value;
		boolean robot;
		
		public Box(int value, boolean robot) {
			this.value = value;
			this.robot = robot;
		}
	}
}