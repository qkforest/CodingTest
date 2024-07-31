import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] formula = br.readLine().split("-");
		int[] numbers = new int[formula.length];
		for(int i = 0; i < formula.length; i++) {
			String[] add = formula[i].split("\\+");
			int temp = 0;
			for(String s : add) {
				temp += Integer.parseInt(s);
			}
			 numbers[i] = temp;
		}
		int answer = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			answer -= numbers[i];
		}
		System.out.print(answer);
	}
}