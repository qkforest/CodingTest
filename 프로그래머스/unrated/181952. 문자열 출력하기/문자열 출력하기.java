import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.length() >= 1 && str.length()<=1000000 && !str.contains(" "))
            System.out.print(str);
    }
}