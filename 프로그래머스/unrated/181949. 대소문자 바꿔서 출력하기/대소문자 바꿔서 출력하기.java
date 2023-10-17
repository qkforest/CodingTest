import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(Pattern.matches("^[a-zA-Z]*$", a)){
            for(char x : a.toCharArray()){
                if(Character.isUpperCase(x))
                    System.out.print(Character.toLowerCase(x));
                else
                    System.out.print(Character.toUpperCase(x));    
            }
        }
    }
}