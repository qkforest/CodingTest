import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 1 && n <= 1000){
            if(n % 2 == 0)
                System.out.print(String.valueOf(n) + " is even");
            else
                System.out.print(String.valueOf(n) + " is odd");
        }
        
    }
}