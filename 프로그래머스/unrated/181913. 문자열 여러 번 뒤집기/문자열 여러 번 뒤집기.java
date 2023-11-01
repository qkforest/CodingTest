class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int[]q : queries){
            String f = "";
            String b = "";
            if(q[0] - 1 >= 0)
                f = my_string.substring(0, q[0]);
            StringBuffer sb = new StringBuffer(my_string.substring(q[0], q[1]+1));
            String reverse = sb.reverse().toString();
            if(q[1] + 1 <= my_string.length())
                b = my_string.substring(q[1]+1);
            my_string = f + reverse + b;
        }
        return my_string;
    }
}