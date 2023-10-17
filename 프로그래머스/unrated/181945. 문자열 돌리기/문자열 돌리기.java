import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(a.length() >= 1 && a.length() <=10){
            for (char x : a.toCharArray())
            System.out.println(x);
        }
    }
}