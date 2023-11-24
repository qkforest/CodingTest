class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n], a1 = new String[n], a2 = new String[n];
        for(int i = 0; i < n; i++){
            String temp = Integer.toBinaryString(arr1[i]|arr2[i]);
            temp = temp.replaceAll("1", "#");
            temp = temp.replaceAll("0", " ");
            if(temp.length() < n)
                temp = " ".repeat(n-temp.length()) + temp;
            answer[i] = temp;
        }
        return answer;
    }
}