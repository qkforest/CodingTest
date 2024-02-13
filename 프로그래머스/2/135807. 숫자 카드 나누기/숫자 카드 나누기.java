class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int minA = 100000000, minB = 100000000, modA = 0, modB = 0;
        for(int i = 0; i < arrayA.length; i++){
            if(minA > arrayA[i]) minA = arrayA[i];
            if(minB > arrayB[i]) minB = arrayB[i];
        }
        for(int i = minA; i >= 2; i--){
            boolean mod = true;
            for(int j = 0; j < arrayA.length; j++){
                if(arrayA[j] % i != 0) {
                    mod = false;
                    break;
                }
            }
            if(mod) {
                modA = i;
                break;
            }
        }
        for(int i = minB; i >= 2; i--){
            boolean mod = true;
            for(int j = 0; j < arrayB.length; j++){
                if(arrayB[j] % i != 0) {
                    mod = false;
                    break;
                }
            }
            if(mod) {
                modB = i;
                break;
            } 
        }
        if(modB != 0){
            boolean mod = true;
            for(int i = 0; i < arrayA.length; i++){
                if(arrayA[i] % modB == 0) {
                    mod = false;
                    break;
                }
            }
            if(mod) answer = modB;
        }
        if(modA != 0){
            boolean mod = true;
            for(int i = 0; i < arrayB.length; i++){
                if(arrayB[i] % modA == 0) {
                    mod = false;
                    break;
                }
            }
            if(mod && answer < modA) answer = modA;
        }
        return answer;
    }
}