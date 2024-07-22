import java.io.*;
	
class Main {
	public static int[] deque;
	public static int size, front, back;
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		deque = new int[10001]; 
		size = 0;
		front = 0;
		back = 0;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
				case "push_front" : 
					pushFront(Integer.parseInt(s[1]));
					break;
				case "push_back" :
					pushBack(Integer.parseInt(s[1]));
					break;
				case "pop_front" : 
					sb.append(popFront()).append("\n");
					break;
				case "pop_back" : 
					sb.append(popBack()).append("\n");
					break;
				case "size" : 
					sb.append(size()).append("\n");
					break;
				case "empty" : 
					sb.append(isEmpty()).append("\n");
					break;
				case "front" : 
					sb.append(front()).append("\n");
					break;
				case "back" : 
					sb.append(back()).append("\n");
					break;
			}
		}
		System.out.print(sb);
 	}
 	public static void pushFront(int X) {
 		deque[front] = X;
 		front = (front - 1 + 10000) % 10000;
 		size++;
 	}
 	public static void pushBack(int X) {
 		back = (back + 1) % 10000;
 		deque[back] = X;
 		size++;
 	}
 	public static int popFront() {
 		if(size == 0) {
 			return -1;
 		}
 		front = (front + 1) % 10000;
 		int pop = deque[front];
 		size--;
 		return pop;
 	}
 	public static int popBack() {
 		if(size == 0) {
 			return -1;
 		}
 		int pop = deque[back];
 		back = (back - 1 + 10000) % 10000;
 		size--;
 		return pop;
 	}
 	public static int size() {
 		return size;
 	}
 	public static int isEmpty() {
 		if(size == 0) {
 			return 1;
 		}
 		return 0;
 	}
 	public static int front() {
 		if(size == 0) {
 			return -1;
 		}
 		return deque[(front + 1) % 10000];
 	}
 	public static int back() {
 		if(size == 0) {
 			return -1;
 		}
 		return deque[back];
 	}

}