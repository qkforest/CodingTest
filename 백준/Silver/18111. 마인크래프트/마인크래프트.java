import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		long B = Long.parseLong(str[2]);
		
		int min = Integer.MAX_VALUE; // 초기 상태에서 최소 높이
		int max = 0; // 초기 상태에서 최대 높이
		
		Map<Integer, Long> counts = new HashMap<>(); // 높이 별 좌표 개수
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(String s : str) {
				int h = Integer.parseInt(s);
				min = Math.min(min, h);
				max = Math.max(max, h);
				counts.merge(h, 1L, Long::sum);
			}
		}
		
		long minTime = Long.MAX_VALUE;
		long maxHeight = 0;
		
		for(int i = min; i <= max; i++) {
			long left = B;
			long time = 0;
			for(int h : counts.keySet()) {
				// 작업 후 높이와 초기 높이가 같으면 넘어가기
				if(h == i) {
					continue;
				} 
				
				long count = counts.get(h); // 해당 높이의 좌표 개수
				
				// 작업 후 높이보다 초기 높이가 큰 경우
				if(h > i) {
					long work = (h - i) * count; // 작업 = 제거해야 할 블록의 개수 * 해당 높이의 좌표 개수
					time += work * 2; // 시간에 작업 * 2를 더함
					left += work; // 인벤토리에 작업 후 얻은 블록을 더함
				} 
				// 작업 후 높기가 초기 높이보다 큰 경우
				else {
					long work = (i - h) * count; // 작업 = 쌓을 블록의 개수 * 해당 높이의 좌표 개수
					time += work; // 시간에 작업을 더함
					left -= work; // 인벤토리에 작업 후 사용한 블록 뺌
				}
				
			}
			
			if(left < 0) {
				continue; // 인벤토리에 남은 블록이 0보다 작다면 해당 경우는 정답에서 제외
			} else {
				// 현재 시간이 minTime보다 작거나 같으면 minTime과 maxHeight을 현재 시간과 높이로 갱신
				if(time <= minTime) {
					minTime = time;
					maxHeight = i;
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		sb.append(minTime).append(" ").append(maxHeight);
		System.out.print(sb);
	}
}