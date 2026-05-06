import java.util.*;

class Solution {
    public static String toString(long n) {
        int len = 0;
        
        for(int i = 1; i <= 11; i++) {
            long c = pow(26, i);
            if(n > c) {
                n -= c;
            } else {
                len = i;
                break;
            }
        }
        
        n--;
        
        char[] result = new char[len];
        for(int i = len - 1; i >= 0; i--) {
            result[i] = (char) ('a' + n % 26);
            n /= 26;
        }
        
        return new String(result);
    }
    
    public static long getOrder(String s) {
        int len = s.length();
        long order = 1;
        
        for(int i = 1; i < len; i++) {
            order += pow(26, i);
        }
        
        for(int i = 0; i < len; i++) {
            int small = s.charAt(i) - 'a';
            order += small * pow(26, len - i - 1);
        }
        
        return order;
    }
    public static long pow(int base, int exp) {
        long result = 1;
        
        for(int i = 0; i < exp; i++) {
            result *= base;
        }
        
        return result;
    }
    
    public String solution(long n, String[] bans) {
        String answer = "";
        int len = bans.length;
        long[] orders = new long[len];
        int c = 0;
        for(int i = 0; i < len; i++) {
            orders[i] = getOrder(bans[i]);
            if(orders[i] <= n) {
                c++;
            }
        }
        
        n += c;
        Arrays.sort(orders);
        
        for(int i = c; i < len; i++) {
            if(orders[i] <= n) {
                n++;
            } else {
                break;
            }
        }
        
        return toString(n);
    }
}