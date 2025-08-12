import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        return Arrays.stream(numbers)
            .mapToObj(String::valueOf)
            .sorted((s1, s2) -> {
                int a = Integer.parseInt(s1+s2);
                int b = Integer.parseInt(s2+s1);
                return b - a;
            })
        .collect(Collectors.joining())
        .replaceAll("^0+", "0");
    }
}