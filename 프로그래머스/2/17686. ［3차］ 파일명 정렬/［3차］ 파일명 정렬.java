import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();
                if(head1.equals(head2)){
                    int num1 = toNum(o1.substring(head1.length()));
                    int num2 = toNum(o2.substring(head2.length()));
                    return num1 - num2;
                } else return head1.compareTo(head2);
            }
        });
        return files;
    }
    public int toNum(String s){
        String num = "";
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                num += c;
            else
                return Integer.parseInt(num.toString());
        }
        return Integer.parseInt(num.toString());
    }
}