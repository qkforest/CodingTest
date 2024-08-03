import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0;i < N; i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		
		int min = stack.pop(); // 현 시점 최소 점수
		int answer = 0; // 감소할 점수의 총합
		
		while(!stack.isEmpty()) {
			int now = stack.pop(); // 현 레벨 점수
			
			/** 
			 * 현 레벨 점수보다 최소 점수가 작거나 같다면 
			 * 현 레벨 점수를 최소 점수보다 1 작은 정수로 만들고 
			 * answer에 감소할 점수를 더함
			 */
			if(now >= min) {
				min--;
				answer += now - min;
			} else {
				min = now; // 최소 점수를 현 레벨 점수로 갱신
			}
			
		}
		
		System.out.print(answer);
	}
}