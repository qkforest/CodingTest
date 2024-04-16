import java.util.*;
class Solution {
    public int solution(int N, int number) {
        HashSet<Integer>[] set = new HashSet[8];
        for(int i = 0; i < 8; i++) {
            set[i] = new HashSet<Integer>();
            String temp = String.valueOf(N).repeat(i+1);
            set[i].add(Integer.parseInt(temp));
            for(int j = 0; j < i; j++) {
                for(int a : set[j]) {
                    for(int b : set[i - j - 1]) {
                        set[i].add(a + b);
                        set[i].add(a - b);
                        set[i].add(a * b);
                        if(b != 0)
                            set[i].add(a / b);
                    }
                }
            }
            if(set[i].contains(number)) {
                return i+1;
            }
        }
        return -1;
    }
}